create view sh_vw_ativacao as 
  select 
  ROW_NUMBER() over (order by pm.Sigcad_ID) id,
  pm.Sigcad_ID as sig_cad_id,
  apm.Serial as serial,
  apm.ShProdutoXMaquina_ID as maquina,
  Convert(date,a.ValidoAte,100) as dt_validade
  from ShAtivacaoXProdutoXMaquina apm 
  inner join ShProdutoXMaquina pm  on pm.Ctrl_ID = apm.ShProdutoXMaquina_ID and pm.Dt_Eliminado is null
  inner join ShProdutoXMaquinaXOpcional pmo on pmo.ShProdutoXMaquina_ID = apm.ShProdutoXMaquina_ID and pmo.Dt_Eliminado is null
  inner join ShProdutoXOpcional po on  pmo.ShProdutoXOpcional_ID = po.Ctrl_ID and po.Dt_Eliminado is null
  inner join ShAtivacao a on apm.ShAtivacao_ID = a.Ctrl_ID
  where apm.shAtivacao_id = (select Max(ShAtivacao_ID) from ShAtivacaoXProdutoXMaquina) 
group by pm.Sigcad_ID,Serial,apm.ShProdutoXMaquina_ID,a.ValidoAte


go
 
create view sh_vw_ativacao_opcionais as 
select 
  ROW_NUMBER() over (order by o.codigomodulo) id,
  o.codigoModulo as codigo_modulo,
  apm.ShProdutoXMaquina_ID as maquina

 from ShAtivacaoXProdutoXMaquina apm
 inner join ShProdutoXMaquinaXOpcional pmo on pmo.ShProdutoXMaquina_ID = apm.ShProdutoXMaquina_ID and pmo.Dt_Eliminado is null
 inner join ShProdutoXOpcional po on  pmo.ShProdutoXOpcional_ID = po.Ctrl_ID and po.Dt_Eliminado is null  
 inner join ShOpcional o on po.ShOpcional_ID = o.Ctrl_ID and o.CodigoModulo between 0 and 47 
 group by CodigoModulo,apm.ShProdutoXMaquina_ID