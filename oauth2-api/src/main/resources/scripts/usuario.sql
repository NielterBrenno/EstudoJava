INSERT INTO public.tb_perfil
(nome)
VALUES('ADMIN');

INSERT INTO public.tb_usuario
(id_usuario, enabled, nome, senha, login)
VALUES(1,true,'Hailton','$2a$10$wH0mX0L5caGUSSsSkk7wEex7pbwBKBqE6HpDFMsu.iDteCZlyzZ5e','admin@hailton');

INSERT INTO public.tb_usuario_tb_perfil
(id_usuario, id_perfil)
VALUES(1, 1);
