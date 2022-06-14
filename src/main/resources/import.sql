insert into COZINHA values (1,'TAILANDIA');
insert into COZINHA values (2,'INDIANA');
insert into COZINHA values (3,'Brasileira');
insert into COZINHA values (4,'Semi-Mexicana');


insert into RESTAURANTE values (1,'MC-MRC',15,1);
insert into RESTAURANTE values (2,'XBC-DX',12.6,2);
insert into RESTAURANTE values (3,'AGFC',69.1,3);
insert into RESTAURANTE values (4,'Mocada',0.58 ,4);

insert into ESTADO (id,nome)    values (1,'São Paulo');
insert into ESTADO (id,nome)    values (2,'M de Minas');
insert into ESTADO (id,nome)    values (3,'P de Parana');
insert into ESTADO (id,nome)    values (4,'S de Santa catarina');

insert into CIDADE (id,nome,estado_id) values (1,'Leme',1);
insert into CIDADE (id,nome,estado_id) values (2,'Cu de Curitiba',3);
insert into CIDADE (id,nome,estado_id) values (3,'Barona',2);
insert into CIDADE (id,nome,estado_id) values (4,'Mano',4);

insert into FORMA_PAGAMENTO (fp_id,descricao) values (1,'Com desconto no cartao');
insert into FORMA_PAGAMENTO (fp_id,descricao) values (2,'Pagamento ao vivo');
insert into FORMA_PAGAMENTO (fp_id,descricao) values (3,'Parcelado a vista');
insert into FORMA_PAGAMENTO (fp_id,descricao) values (4,'Via B de Bola');

insert into PERMISSAO (id,nome,descricao) values (1,'Vale tudo','Ta liberado')
insert into PERMISSAO (id,nome,descricao) values (2,'MMA','Todos os estilos')
insert into PERMISSAO (id,nome,descricao) values (3,'JUDO','Hummm luta agarada')
insert into PERMISSAO (id,nome,descricao) values (4,'BOX','So porrada')