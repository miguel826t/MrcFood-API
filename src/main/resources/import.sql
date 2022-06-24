insert into COZINHA values (1,'Polonesa');
insert into COZINHA values (2,'Europeia');
insert into COZINHA values (3,'Brasileira');
insert into COZINHA values (4,'Semi-Mexicana');
insert into COZINHA values (5,'Mexicana');
insert into COZINHA values (6,'Peruana');

insert into RESTAURANTE values (1,'Especialista Europeia',15,1);
insert into RESTAURANTE values (2,'Amburges franceses',12.6,2);
insert into RESTAURANTE values (3,'Brasuca free',69.1,3);
insert into RESTAURANTE values (4,'Tacos do xico',0.58 ,4);

insert into ESTADO (id,nome)    values (1,'Sao Paulo');
insert into ESTADO (id,nome)    values (2,'Minas');
insert into ESTADO (id,nome)    values (3,'Para');
insert into ESTADO (id,nome)    values (4,'Santa catarina');
insert into ESTADO (id,nome)    values (5,'Rio grande do norte');
insert into ESTADO (id,nome)    values (6,'Paraiba');
insert into ESTADO (id,nome)    values (7,'Rio grande do sul');
insert into ESTADO (id,nome)    values (8,'Rio de janeiro');
insert into ESTADO (id,nome)    values (9,'Espirito santo');

insert into CIDADE (id,nome,estado_id) values (1,'Leme-Sp',1);
insert into CIDADE (id,nome,estado_id) values (2,'Cidade-Minas',2);
insert into CIDADE (id,nome,estado_id) values (3,'Cidade-Para',3);
insert into CIDADE (id,nome,estado_id) values (4,'Cidade-SC',4);
insert into CIDADE (id,nome,estado_id) values (5,'Cidade-RJ',5);
insert into CIDADE (id,nome,estado_id) values (6,'Cidade-RP',6);
insert into CIDADE (id,nome,estado_id) values (7,'Cidade-Paraiba',7);
insert into CIDADE (id,nome,estado_id) values (8,'Cidade-RS',8);
insert into CIDADE (id,nome,estado_id) values (9,'Cidade-ES',9);

insert into FORMA_PAGAMENTO (fp_id,descricao) values (1,'Com desconto no cartao');
insert into FORMA_PAGAMENTO (fp_id,descricao) values (2,'Pagamento ao vivo');
insert into FORMA_PAGAMENTO (fp_id,descricao) values (3,'Parcelado a vista');
insert into FORMA_PAGAMENTO (fp_id,descricao) values (4,'Via B de Bola');

insert into PERMISSAO (id,nome,descricao) values (1,'Vale tudo','Ta liberado')
insert into PERMISSAO (id,nome,descricao) values (2,'MMA','Todos os estilos')
insert into PERMISSAO (id,nome,descricao) values (3,'JUDO','Hummm luta agarada')
insert into PERMISSAO (id,nome,descricao) values (4,'BOX','So porrada')