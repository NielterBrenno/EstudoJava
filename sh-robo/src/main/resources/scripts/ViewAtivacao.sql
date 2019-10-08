alter table [dbo].[ShAtivacaoXProdutoXMaquina] add
        atualizado int Null
GO

update ShAtivacao set ValidoAte = CAST('01/08/2020' as date)
where CTRL_ID in (select ShAtivacao_ID from ShAtivacaoXProdutoXMaquina where ShProdutoXMaquina_ID in(
select CTRL_ID from ShProdutoXMaquina where Dt_Eliminado is null))
and Sigcad_ID in (select c.CODIGO from SIGCAD c inner join ProvisaoFluxoItem f on
(f.ClienteFornecedor = c.CODIGO) and (f.Ativo = 'S')
 where c.bloqueio in (0,NULL) and c.tipo like '%CONTR%') and YEAR(ValidoAte) >= YEAR(Getdate())-1

GO

 update ShAtivacaoXProdutoXMaquina set  atualizado = 1 
where ShAtivacao_ID in( select CTRL_ID from ShAtivacao where ValidoAte = '01/08/2020' )

GO

update ShAtivacaoXProdutoXMaquina set  atualizado = 0 
where atualizado  is null

GO

update ShAtivacaoXProdutoXMaquina set  atualizado = null 
where atualizado  = 1 

GO


create view sh_vw_ativacao_opcionais as 
select 
  ROW_NUMBER() over (order by apm.ShProdutoXMaquina_ID) id,
  o.codigoModulo as codigo_modulo,
  apm.ShProdutoXMaquina_ID as maquina

 from ShAtivacaoXProdutoXMaquina apm
 inner join ShProdutoXMaquinaXOpcional pmo on pmo.ShProdutoXMaquina_ID = apm.ShProdutoXMaquina_ID and pmo.Dt_Eliminado is null
 inner join ShProdutoXOpcional po on  pmo.ShProdutoXOpcional_ID = po.Ctrl_ID and po.Dt_Eliminado is null  
 inner join ShOpcional o on po.ShOpcional_ID = o.Ctrl_ID and o.CodigoModulo between 0 and 47 
 group by CodigoModulo,apm.ShProdutoXMaquina_ID

GO

create view sh_vw_ativacao as 
 Select
distinct
 apm.Ctrl_ID as ctrl_id
,a.Sigcad_ID as sig_cad_id
,replace(apm.Serial,'@','') as serial
,apm.ShProdutoXMaquina_ID as maquina
,Convert(date,a.ValidoAte,100) as dt_validade
from ShProdutoXMaquina PM 
left join (select max(ShAtivacaoXProdutoXMaquina.Ctrl_ID) as Ctrl_Id, ShAtivacaoXProdutoXMaquina.ShProdutoXMaquina_ID 
             from ShAtivacaoXProdutoXMaquina
           group by ShAtivacaoXProdutoXMaquina.ShProdutoXMaquina_ID) UltimaAtivacao on PM.Ctrl_ID = UltimaAtivacao.ShProdutoXMaquina_ID 
left  join ShAtivacaoXProdutoXMaquina APM on APM.Ctrl_Id = UltimaAtivacao.Ctrl_Id
left  join shAtivacao A on A.Ctrl_Id = APM.ShAtivacao_ID and PM.Dt_Eliminado is null
inner join ShProduto P on P.Ctrl_ID = PM.ShProduto_ID and P.Dt_Eliminado is null
inner join ShMaquina M on M.Ctrl_ID = PM.ShMaquina_ID and M.Dt_Eliminado is null
inner join ShProdutoXMaquinaXOpcional pmo on (pmo.ShProdutoXMaquina_ID =APM.ShProdutoXMaquina_ID and pmo.Dt_Eliminado is null)
inner join ShProdutoXOpcional po on (pmo.ShProdutoXOpcional_ID = po.Ctrl_ID and po.Dt_Eliminado is null)
inner join ShOpcional o on o.Ctrl_ID= po.ShOpcional_ID and o.Dt_Eliminado is null
inner join Sigcad cliente on cliente.Codigo = A.Sigcad_ID
where A.SIGCAD_ID >2  and apm.atualizado is null
group by 
apm.Ctrl_ID 
,A.SIGCAD_ID
,apm.Serial
,apm.ShProdutoXMaquina_ID
,a.ValidoAte
