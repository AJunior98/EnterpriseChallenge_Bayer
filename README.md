# Descrição - EnterpriseChallenge_Bayer

Sistema para monitoramento da quantidade de casos de zika, malária e dengue no primeiro trimestre por região do Brasil (Norte, Nordeste, Centro-Oeste, Sudeste e Sul) para empresa Bayer.

# 1 - Modelagem de dados

## Modelo lógico relacional do sistema
![image](https://user-images.githubusercontent.com/100853329/172004802-d6341e4a-4c9f-4aea-9f6f-9c6199b38e65.png)

![image](https://user-images.githubusercontent.com/100853329/172004874-58015eb2-d809-4a97-9877-6ae843ba1758.png)

# 2 - Criação do modelo físico
- Abaixo o script da modelagem gerada e utilizada no backend como amostra de dados.

```sql
-- Criando DataBase
create database enterprisechallenge;

-- Referenciando DataBase
use enterprisechallenge;

-- Criação de tabela doença
CREATE TABLE T_MNT_DOENCA (
	id INT NOT NULL AUTO_INCREMENT,
	tp_doenca VARCHAR(30),
	PRIMARY KEY (id)
);

-- Criação de tabela pessoa
CREATE TABLE T_MNT_PESSOA (
	id INT NOT NULL AUTO_INCREMENT,
    nr_cpf  VARCHAR(11),
	nm_regiao VARCHAR(30),
	dt_mescontagio VARCHAR(30),
	nm_genero VARCHAR(10),
	nr_idade INT(3),
	id_doenca INT(11) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (id_doenca) REFERENCES T_MNT_DOENCA (id)
);

-- Inserção dos tipos de doenças existentes
INSERT INTO T_MNT_DOENCA(tp_doenca) VALUES ('Zika'), ('Malaria'), ('Dengue');

-- Inserção dos dados gerados pelo Renato
INSERT INTO T_MNT_PESSOA (nr_cpf, dt_mesContagio, nm_regiao, nm_genero, nr_idade, id_doenca) VALUES ('12557760412','Janeiro','Nordeste','Masculino',79,3),
('12561649601','Março','Nordeste','Masculino',61,3),
('12695342835','Janeiro','Norte','Feminino',52,1),
('12964793623','Fevereiro','Centro-Oeste','Masculino',94,1),
('13195867096','Janeiro','Sudeste','Feminino',30,2),
('13195867096','Março','Sudeste','Feminino',30,2),
('13506447919','Março','Sudeste','Feminino',57,2),
('13706236597','Março','Sul','Masculino',84,2),
('14665036123','Fevereiro','Nordeste','Masculino',32,1),
('14665036123','Março','Nordeste','Masculino',32,3),
('15026707579','Janeiro','Centro-Oeste','Masculino',57,1),
('15081213998','Fevereiro','Sudeste','Masculino',53,3),
('15119465705','Janeiro','Nordeste','Masculino',68,3),
('15136216134','Março','Norte','Masculino',0,2),
('15661661729','Março','Sul','Feminino',99,2),
('15707160023','Março','Centro-Oeste','Feminino',23,3),
('15739991708','Janeiro','Nordeste','Masculino',75,1),
('16137956725','Janeiro','Nordeste','Masculino',9,1),
('16351030309','Janeiro','Nordeste','Masculino',84,2),
('16438216559','Março','Norte','Masculino',78,2),
('16463437711','Janeiro','Sul','Feminino',73,2),
('16549786059','Março','Sul','Masculino',50,2),
('16655577851','Janeiro','Norte','Feminino',87,3),
('16997355122','Março','Centro-Oeste','Masculino',18,3),
('17155208090','Março','Norte','Masculino',73,3),
('17202400898','Janeiro','Sudeste','Masculino',87,1),
('17564648741','Janeiro','Norte','Masculino',27,3),
('17674239444','Janeiro','Sul','Masculino',11,1),
('18222379303','Março','Sudeste','Feminino',12,1),
('18740440727','Janeiro','Norte','Feminino',63,1),
('18936084126','Fevereiro','Sudeste','Feminino',40,3),
('18968538048','Fevereiro','Centro-Oeste','Masculino',76,2),
('19607794972','Fevereiro','Nordeste','Masculino',29,3),
('19714820851','Março','Sul','Masculino',17,1),
('19789309759','Fevereiro','Sudeste','Masculino',23,3),
('20078092939','Janeiro','Sudeste','Masculino',20,1),
('20132011767','Março','Nordeste','Feminino',56,3),
('20611057415','Janeiro','Centro-Oeste','Masculino',11,2),
('20725871150','Fevereiro','Sudeste','Masculino',45,1),
('21060842297','Janeiro','Sudeste','Masculino',61,1),
('21087502368','Fevereiro','Sudeste','Masculino',25,1),
('21249572056','Março','Sudeste','Masculino',91,1),
('21590835809','Março','Sudeste','Masculino',83,1),
('21673459449','Março','Nordeste','Feminino',18,2),
('21845324378','Fevereiro','Centro-Oeste','Masculino',92,3),
('21868509573','Março','Sul','Feminino',31,2),
('21897721451','Março','Sudeste','Feminino',70,3),
('22089259973','Março','Sul','Masculino',70,2),
('22342679829','Março','Norte','Masculino',81,3),
('22358216787','Março','Centro-Oeste','Feminino',40,1),
('22374141665','Março','Sudeste','Feminino',16,2),
('22530897039','Janeiro','Sudeste','Masculino',28,3),
('23104122899','Fevereiro','Sudeste','Masculino',52,1),
('23134780173','Março','Nordeste','Masculino',55,2),
('23712086051','Fevereiro','Norte','Masculino',27,3),
('23798269480','Fevereiro','Centro-Oeste','Feminino',71,2),
('24130416642','Março','Sudeste','Masculino',46,1),
('24333592936','Março','Nordeste','Feminino',99,2),
('24342019239','Março','Sul','Masculino',71,3),
('24891531937','Março','Sudeste','Feminino',0,3),
('25013473005','Janeiro','Sudeste','Masculino',70,2),
('25169999915','Janeiro','Sudeste','Masculino',16,3),
('25206991808','Janeiro','Centro-Oeste','Feminino',67,2),
('25596517845','Janeiro','Centro-Oeste','Feminino',75,2),
('25645409688','Janeiro','Sul','Feminino',40,3),
('25959218581','Fevereiro','Sudeste','Masculino',81,1),
('25978539144','Janeiro','Centro-Oeste','Masculino',87,1),
('26018273642','Janeiro','Centro-Oeste','Masculino',29,3),
('26071793725','Janeiro','Norte','Feminino',6,2),
('26312936966','Janeiro','Norte','Masculino',36,1),
('26453849186','Janeiro','Sul','Feminino',5,2),
('26510168442','Fevereiro','Sul','Feminino',20,1),
('26922863467','Janeiro','Norte','Masculino',1,1),
('26976341417','Fevereiro','Nordeste','Feminino',34,2),
('27292624567','Fevereiro','Sudeste','Feminino',51,3),
('27385228719','Janeiro','Centro-Oeste','Feminino',80,1),
('27541456241','Março','Centro-Oeste','Feminino',41,1),
('28032050386','Janeiro','Norte','Feminino',28,3),
('28140729740','Janeiro','Sul','Feminino',45,3),
('28614845131','Fevereiro','Sudeste','Feminino',35,1),
('28718345729','Março','Centro-Oeste','Feminino',5,3),
('29062488434','Janeiro','Sul','Masculino',98,2),
('29142728337','Fevereiro','Centro-Oeste','Feminino',38,3),
('29363793820','Março','Sudeste','Feminino',2,2),
('29465101574','Março','Sul','Feminino',32,2),
('29730432740','Fevereiro','Norte','Masculino',85,3),
('29732217296','Janeiro','Nordeste','Feminino',77,1),
('29769616223','Março','Sudeste','Feminino',23,1),
('29784122556','Fevereiro','Norte','Masculino',7,3),
('29862103328','Janeiro','Sul','Masculino',96,1),
('30149477859','Março','Norte','Feminino',41,2),
('30364752637','Janeiro','Norte','Feminino',42,1),
('30702986049','Janeiro','Centro-Oeste','Feminino',6,2),
('30986827728','Março','Sul','Feminino',23,3),
('31106816510','Fevereiro','Nordeste','Feminino',14,1),
('31106816510','Janeiro','Nordeste','Feminino',14,2),
('31138433875','Janeiro','Centro-Oeste','Masculino',19,2),
('31138433875','Março','Centro-Oeste','Masculino',19,3),
('31282184686','Março','Centro-Oeste','Feminino',8,3),
('31385365214','Março','Norte','Masculino',41,2),
('31907415260','Março','Norte','Masculino',55,2),
('32048760711','Março','Norte','Masculino',1,3),
('32057615814','Março','Norte','Feminino',85,1),
('32073903733','Janeiro','Sudeste','Masculino',44,2),
('32356455850','Fevereiro','Sul','Masculino',64,1),
('32811531672','Janeiro','Centro-Oeste','Masculino',15,3),
('32889251166','Janeiro','Nordeste','Feminino',38,1),
('33370222282','Março','Centro-Oeste','Feminino',72,2),
('33636506664','Março','Norte','Masculino',74,1),
('33901434219','Março','Centro-Oeste','Feminino',2,2),
('33968419490','Março','Norte','Feminino',87,2),
('33968419490','Fevereiro','Norte','Feminino',87,3),
('34538802061','Março','Centro-Oeste','Feminino',47,2),
('35002920508','Março','Centro-Oeste','Feminino',49,3),
('35201061961','Janeiro','Centro-Oeste','Masculino',38,3),
('35214641193','Janeiro','Centro-Oeste','Masculino',38,1),
('35287182411','Março','Sul','Masculino',59,2),
('35311945739','Março','Sul','Masculino',8,2),
('35478384779','Fevereiro','Sudeste','Masculino',33,3),
('35664805921','Fevereiro','Norte','Masculino',32,1),
('35664805921','Janeiro','Norte','Masculino',32,2),
('35826693404','Janeiro','Sul','Masculino',40,1),
('36176498776','Janeiro','Centro-Oeste','Feminino',10,3),
('36795401541','Janeiro','Sudeste','Feminino',13,1),
('37468796448','Janeiro','Norte','Masculino',3,3),
('37956065723','Março','Centro-Oeste','Feminino',95,1),
('38002120846','Janeiro','Sudeste','Feminino',77,3),
('38103016597','Fevereiro','Sul','Masculino',50,1),
('38134551400','Janeiro','Norte','Masculino',42,2),
('38323925948','Fevereiro','Centro-Oeste','Feminino',4,2),
('38330294050','Março','Centro-Oeste','Masculino',9,3),
('38466481801','Março','Centro-Oeste','Feminino',96,1),
('38586504912','Janeiro','Sul','Masculino',10,2),
('38771669133','Fevereiro','Norte','Feminino',54,1),
('38852861226','Fevereiro','Nordeste','Feminino',79,1),
('39478733142','Março','Sudeste','Feminino',37,3),
('39521373545','Fevereiro','Sul','Feminino',35,3),
('39856733198','Fevereiro','Centro-Oeste','Masculino',85,1),
('40383345823','Março','Centro-Oeste','Masculino',85,2),
('40462860241','Fevereiro','Sudeste','Masculino',14,3),
('40507773574','Março','Nordeste','Feminino',67,1),
('40523559001','Janeiro','Centro-Oeste','Feminino',18,1),
('40523559001','Março','Centro-Oeste','Feminino',18,2),
('40733695053','Janeiro','Sudeste','Feminino',76,1),
('40941184676','Janeiro','Sudeste','Masculino',6,3),
('41099305629','Janeiro','Sul','Masculino',27,1),
('41571045711','Março','Norte','Masculino',11,3),
('41694891382','Fevereiro','Sul','Masculino',43,3),
('41865964081','Janeiro','Norte','Masculino',12,3),
('41878198666','Janeiro','Centro-Oeste','Masculino',42,3),
('42062638670','Fevereiro','Nordeste','Masculino',98,1),
('42071787391','Fevereiro','Norte','Masculino',75,2),
('42219412448','Fevereiro','Nordeste','Masculino',27,1),
('42219412448','Março','Nordeste','Masculino',27,2),
('42467213634','Março','Centro-Oeste','Feminino',6,1),
('42592503690','Janeiro','Norte','Feminino',37,3),
('42702984242','Fevereiro','Sul','Feminino',93,3),
('43120452670','Janeiro','Sul','Masculino',45,3),
('43121435663','Janeiro','Sul','Feminino',55,3),
('43201070631','Fevereiro','Norte','Feminino',5,1),
('43407922077','Março','Centro-Oeste','Masculino',81,1),
('43583654960','Março','Sudeste','Masculino',60,1),
('43610196870','Março','Nordeste','Masculino',38,1),
('43618371664','Março','Nordeste','Feminino',17,2),
('43674304111','Março','Sul','Feminino',51,3),
('43878746535','Janeiro','Centro-Oeste','Feminino',63,3),
('44098247936','Fevereiro','Sudeste','Feminino',88,3),
('44373831819','Janeiro','Norte','Masculino',10,3),
('44375246463','Janeiro','Sudeste','Feminino',46,2),
('44405085761','Fevereiro','Norte','Feminino',27,1),
('44519418528','Janeiro','Sul','Feminino',80,1),
('44636811751','Fevereiro','Sudeste','Masculino',17,2),
('44862652724','Março','Centro-Oeste','Masculino',63,3),
('44926719894','Fevereiro','Sudeste','Feminino',77,2),
('44953195102','Março','Sudeste','Feminino',59,1),
('44955044500','Março','Centro-Oeste','Masculino',9,3),
('45105734936','Fevereiro','Sudeste','Masculino',24,2),
('45155319305','Janeiro','Sul','Masculino',39,2),
('45232679299','Março','Sul','Feminino',16,2),
('45534613153','Março','Nordeste','Feminino',36,1),
('45534613153','Janeiro','Nordeste','Feminino',36,3),
('45725780178','Fevereiro','Centro-Oeste','Feminino',66,1),
('45794287224','Fevereiro','Norte','Masculino',28,1),
('45826738265','Março','Centro-Oeste','Feminino',40,1),
('45932851757','Janeiro','Nordeste','Masculino',87,3),
('45948851620','Fevereiro','Norte','Masculino',40,3),
('46218167931','Janeiro','Norte','Masculino',59,2),
('46394525395','Fevereiro','Nordeste','Feminino',67,1),
('46526318804','Fevereiro','Norte','Masculino',12,3),
('46573643211','Janeiro','Norte','Masculino',30,1),
('46589167346','Março','Sudeste','Feminino',73,2),
('46724218115','Fevereiro','Centro-Oeste','Feminino',40,3),
('47000696215','Janeiro','Norte','Masculino',21,1),
('47912018287','Janeiro','Centro-Oeste','Masculino',58,3),
('48543090049','Março','Centro-Oeste','Masculino',34,2),
('49414468840','Janeiro','Centro-Oeste','Feminino',65,1),
('49495406718','Fevereiro','Nordeste','Feminino',33,2),
('49495406718','Janeiro','Nordeste','Feminino',33,3),
('49523725477','Março','Norte','Feminino',61,2),
('49775759333','Janeiro','Sul','Feminino',2,3),
('50275830352','Março','Sudeste','Feminino',39,1),
('50314713832','Fevereiro','Centro-Oeste','Masculino',95,3),
('50513634114','Fevereiro','Nordeste','Masculino',54,2),
('50724420995','Fevereiro','Centro-Oeste','Masculino',99,2),
('51023187411','Março','Sul','Feminino',72,2),
('51155243810','Março','Sudeste','Feminino',23,2),
('51708577822','Janeiro','Nordeste','Masculino',69,2),
('51854619884','Março','Sul','Masculino',47,1),
('52022245065','Março','Sul','Masculino',86,2),
('52113507484','Janeiro','Nordeste','Feminino',12,1),
('52763829295','Janeiro','Sudeste','Feminino',12,3),
('52792506548','Fevereiro','Sul','Masculino',61,1),
('52872373740','Março','Sul','Masculino',27,1),
('53039326170','Fevereiro','Norte','Masculino',26,3),
('53092011809','Março','Sudeste','Feminino',40,3),
('53352840521','Janeiro','Norte','Feminino',56,3),
('53480584402','Março','Sudeste','Feminino',86,1),
('53499551115','Março','Norte','Masculino',89,1),
('53845671935','Fevereiro','Sudeste','Feminino',95,1),
('53845671935','Janeiro','Sudeste','Feminino',95,3),
('53878131125','Janeiro','Sul','Masculino',22,3),
('54236199181','Março','Centro-Oeste','Feminino',75,3),
('54241147496','Fevereiro','Sudeste','Masculino',18,2),
('54241147496','Março','Sudeste','Masculino',18,3),
('54552276123','Fevereiro','Centro-Oeste','Feminino',78,2),
('55107162565','Fevereiro','Sudeste','Feminino',76,1),
('55431756691','Março','Norte','Feminino',94,1),
('55506452682','Janeiro','Centro-Oeste','Masculino',27,1),
('55948566053','Março','Sudeste','Masculino',24,2),
('55973748971','Janeiro','Nordeste','Masculino',42,1),
('56150600267','Janeiro','Centro-Oeste','Masculino',62,2),
('56167887023','Janeiro','Centro-Oeste','Feminino',75,3),
('56488626201','Março','Sul','Feminino',2,2),
('56497530121','Fevereiro','Sul','Masculino',45,1),
('56799599860','Janeiro','Norte','Masculino',86,2),
('57206029711','Janeiro','Sul','Feminino',54,1),
('57206029711','Janeiro','Sul','Feminino',54,3),
('57433558814','Janeiro','Nordeste','Masculino',4,2),
('57736276584','Fevereiro','Sul','Feminino',19,1),
('57788547844','Janeiro','Sudeste','Masculino',35,1),
('57813097008','Março','Norte','Feminino',16,3),
('57846039758','Março','Sul','Feminino',81,2),
('57846039758','Março','Sul','Feminino',81,3),
('57874609657','Março','Centro-Oeste','Masculino',6,1),
('57955542462','Março','Sul','Feminino',83,2),
('58221209732','Março','Centro-Oeste','Masculino',0,2),
('58279907007','Janeiro','Sul','Masculino',89,1),
('58529488070','Março','Nordeste','Masculino',5,2),
('58576640588','Fevereiro','Sul','Feminino',24,2),
('58633308280','Março','Sudeste','Feminino',73,3),
('58850598361','Março','Sul','Masculino',10,1),
('58914747117','Março','Sudeste','Masculino',28,1),
('59120127127','Janeiro','Sudeste','Masculino',10,3),
('59127398233','Janeiro','Sul','Masculino',67,2),
('59403378299','Março','Norte','Masculino',84,3),
('59605911361','Fevereiro','Centro-Oeste','Feminino',5,3),
('59619621965','Março','Nordeste','Feminino',59,3),
('59724894833','Março','Sudeste','Masculino',63,2),
('59731859149','Fevereiro','Sudeste','Feminino',66,2),
('59785636613','Janeiro','Norte','Feminino',89,1),
('59874578685','Janeiro','Sudeste','Masculino',50,2),
('59912161963','Fevereiro','Nordeste','Masculino',17,1),
('59912161963','Janeiro','Nordeste','Masculino',17,2),
('59939559535','Março','Sudeste','Feminino',23,2),
('59968941226','Março','Sudeste','Feminino',9,2),
('60444500239','Janeiro','Sudeste','Feminino',70,3),
('60612202267','Janeiro','Norte','Feminino',68,1),
('60894840884','Março','Centro-Oeste','Feminino',6,1),
('60901604659','Fevereiro','Sul','Feminino',70,1),
('60910943296','Março','Centro-Oeste','Masculino',11,3),
('60980433494','Fevereiro','Nordeste','Masculino',8,3),
('61140564196','Fevereiro','Centro-Oeste','Feminino',90,1),
('61757643452','Março','Norte','Feminino',56,1),
('61766056280','Fevereiro','Nordeste','Masculino',65,3),
('61771637007','Janeiro','Sul','Feminino',4,1),
('61880673109','Fevereiro','Norte','Feminino',9,3),
('61954443453','Janeiro','Sudeste','Masculino',48,3),
('61985378079','Fevereiro','Nordeste','Feminino',41,2),
('61985378079','Março','Nordeste','Feminino',41,3),
('62079969473','Março','Sul','Feminino',20,3),
('62143201141','Fevereiro','Norte','Feminino',16,1),
('62194615003','Janeiro','Norte','Masculino',91,2),
('62319474777','Março','Centro-Oeste','Feminino',83,1),
('62567165043','Março','Centro-Oeste','Feminino',49,2),
('62610646644','Março','Sudeste','Masculino',74,3),
('62641246550','Março','Sul','Masculino',91,3),
('62735351490','Março','Norte','Feminino',49,1),
('62735351490','Janeiro','Norte','Feminino',49,1),
('62809458423','Janeiro','Centro-Oeste','Feminino',83,1),
('62822494225','Janeiro','Sul','Masculino',26,3),
('63046263261','Março','Centro-Oeste','Feminino',35,3),
('63074703368','Fevereiro','Sudeste','Feminino',39,2),
('63113116994','Fevereiro','Nordeste','Masculino',64,1),
('63113116994','Janeiro','Nordeste','Masculino',64,2),
('63113116994','Março','Nordeste','Masculino',64,3),
('63125462709','Março','Sudeste','Masculino',0,2),
('63250734907','Março','Centro-Oeste','Masculino',68,2),
('63392271055','Março','Nordeste','Feminino',46,2),
('63584671798','Janeiro','Sul','Masculino',44,1),
('63634139261','Fevereiro','Norte','Feminino',87,2),
('63707866235','Março','Sul','Feminino',94,3),
('63838694687','Janeiro','Norte','Masculino',90,3),
('64084636255','Fevereiro','Sudeste','Feminino',33,3),
('64226973263','Março','Sudeste','Feminino',65,1),
('64411272023','Fevereiro','Centro-Oeste','Feminino',67,1),
('64569656479','Março','Centro-Oeste','Masculino',66,3),
('65274265751','Março','Nordeste','Masculino',37,3),
('65321524760','Fevereiro','Norte','Feminino',61,1),
('65655919930','Fevereiro','Centro-Oeste','Feminino',29,3),
('66102844105','Janeiro','Norte','Masculino',57,2),
('66188467093','Fevereiro','Sul','Feminino',29,1),
('66273326856','Março','Sul','Feminino',79,2),
('66306596920','Fevereiro','Centro-Oeste','Masculino',6,2),
('66566901999','Fevereiro','Nordeste','Feminino',62,3),
('66982657194','Fevereiro','Norte','Feminino',25,1),
('66997353414','Fevereiro','Norte','Feminino',49,3),
('67100988702','Março','Centro-Oeste','Feminino',21,3),
('67246679225','Fevereiro','Sudeste','Feminino',43,2),
('67733516104','Fevereiro','Nordeste','Feminino',17,3),
('68910722012','Março','Sudeste','Masculino',95,2),
('68976907819','Janeiro','Sul','Feminino',16,2),
('69174361488','Fevereiro','Sudeste','Masculino',19,2),
('69871186164','Fevereiro','Sudeste','Masculino',79,1),
('69871186164','Janeiro','Sudeste','Masculino',79,2),
('69993851042','Fevereiro','Sudeste','Feminino',59,1),
('69993851042','Março','Sudeste','Feminino',59,3),
('70096689708','Fevereiro','Centro-Oeste','Masculino',85,2),
('70309195211','Março','Sudeste','Masculino',46,2),
('70426407744','Fevereiro','Centro-Oeste','Feminino',5,1),
('70665680313','Janeiro','Centro-Oeste','Feminino',82,1),
('70665680313','Fevereiro','Centro-Oeste','Feminino',82,3),
('70986396430','Janeiro','Nordeste','Masculino',27,1),
('71001995513','Fevereiro','Sul','Feminino',52,1),
('71049960880','Fevereiro','Centro-Oeste','Masculino',97,3),
('71215129818','Janeiro','Sul','Feminino',82,3),
('71367038151','Janeiro','Centro-Oeste','Masculino',91,1),
('71388235603','Março','Norte','Masculino',61,1),
('71450373548','Março','Norte','Feminino',60,2),
('71491333902','Fevereiro','Nordeste','Masculino',71,3),
('71736400405','Janeiro','Nordeste','Feminino',84,2),
('71919339885','Fevereiro','Nordeste','Masculino',6,3),
('71957735882','Fevereiro','Nordeste','Feminino',37,2),
('72473626699','Janeiro','Sudeste','Feminino',79,1),
('72473626699','Março','Sudeste','Feminino',79,2),
('72473626699','Fevereiro','Sudeste','Feminino',79,3),
('72498275418','Fevereiro','Centro-Oeste','Feminino',83,1),
('72642499543','Janeiro','Sudeste','Feminino',66,2),
('73064809163','Fevereiro','Norte','Masculino',4,1),
('73121321413','Fevereiro','Sudeste','Masculino',61,3),
('73308627259','Fevereiro','Sudeste','Feminino',80,1),
('73448667985','Fevereiro','Sul','Feminino',82,2),
('73669138080','Março','Centro-Oeste','Masculino',38,2),
('74049868134','Fevereiro','Sul','Masculino',9,1),
('74339659785','Fevereiro','Centro-Oeste','Masculino',37,3),
('74493906162','Fevereiro','Centro-Oeste','Feminino',45,3),
('74632218519','Março','Sul','Masculino',38,3),
('74758675586','Março','Centro-Oeste','Feminino',0,2),
('74760170930','Março','Norte','Feminino',34,2),
('74786907105','Janeiro','Norte','Feminino',10,3),
('74935459394','Janeiro','Sudeste','Masculino',74,1),
('75167619687','Fevereiro','Norte','Masculino',39,1),
('75242887470','Março','Sul','Masculino',24,1),
('75457046242','Janeiro','Sul','Feminino',99,3),
('75664708096','Janeiro','Norte','Masculino',27,3),
('75813979952','Março','Norte','Masculino',7,3),
('75960491378','Janeiro','Nordeste','Masculino',57,3),
('75972595360','Janeiro','Centro-Oeste','Feminino',33,3),
('76019181830','Fevereiro','Centro-Oeste','Feminino',50,3),
('76048555445','Janeiro','Nordeste','Feminino',21,2),
('76233828169','Janeiro','Sul','Masculino',14,3),
('76353857039','Março','Norte','Masculino',98,2),
('76484458051','Fevereiro','Nordeste','Feminino',11,3),
('76700807498','Janeiro','Sudeste','Feminino',48,2),
('76906622641','Março','Sudeste','Masculino',53,2),
('76916920410','Janeiro','Centro-Oeste','Masculino',38,2),
('77310246520','Janeiro','Norte','Masculino',11,3),
('77598956283','Janeiro','Sudeste','Masculino',52,3),
('77711685724','Janeiro','Nordeste','Feminino',86,2),
('77976775502','Março','Norte','Masculino',56,2),
('78603322522','Janeiro','Sul','Masculino',1,2),
('78811411772','Fevereiro','Nordeste','Feminino',7,2),
('78920941325','Fevereiro','Centro-Oeste','Feminino',4,2),
('79115661528','Fevereiro','Sul','Feminino',8,2),
('79233966030','Fevereiro','Sul','Feminino',76,1),
('79250219977','Março','Sul','Masculino',93,3),
('79394262554','Janeiro','Sudeste','Masculino',22,1),
('79573252683','Março','Norte','Masculino',57,2),
('79599421707','Fevereiro','Norte','Feminino',58,2),
('79902199912','Março','Centro-Oeste','Masculino',96,3),
('79966554213','Janeiro','Nordeste','Masculino',44,3),
('80158895966','Março','Norte','Feminino',55,2),
('80222844387','Fevereiro','Sudeste','Masculino',28,1),
('80601674010','Março','Sul','Masculino',56,3),
('80705410950','Janeiro','Sul','Feminino',38,3),
('80732191474','Março','Sul','Masculino',39,3),
('80941408397','Fevereiro','Sudeste','Feminino',18,2),
('80941408397','Janeiro','Sudeste','Feminino',18,2),
('80949198037','Fevereiro','Nordeste','Feminino',6,2),
('81096203748','Março','Nordeste','Masculino',18,3),
('81274034840','Janeiro','Norte','Feminino',65,3),
('81372459269','Janeiro','Sul','Feminino',92,3),
('81394215127','Março','Norte','Masculino',38,2),
('81491521924','Janeiro','Sudeste','Feminino',83,3),
('81525638488','Março','Sudeste','Feminino',21,2),
('81919855653','Janeiro','Sul','Feminino',81,1),
('82331441537','Março','Norte','Feminino',90,2),
('82379455915','Março','Centro-Oeste','Masculino',67,1),
('82467837875','Março','Sudeste','Masculino',13,3),
('82519455548','Fevereiro','Nordeste','Masculino',95,2),
('82530101280','Fevereiro','Centro-Oeste','Feminino',14,3),
('82782209721','Março','Sul','Masculino',72,2),
('82974530364','Março','Norte','Feminino',15,1),
('83061379098','Janeiro','Sul','Feminino',84,2),
('83153092844','Março','Nordeste','Masculino',35,3),
('83397957264','Janeiro','Nordeste','Masculino',29,1),
('83417310237','Fevereiro','Centro-Oeste','Masculino',42,2),
('83574370586','Março','Nordeste','Masculino',38,3),
('83688857767','Fevereiro','Norte','Masculino',48,2),
('83707178103','Janeiro','Centro-Oeste','Masculino',74,3),
('83781705930','Março','Norte','Feminino',3,2),
('84040124860','Fevereiro','Sudeste','Feminino',26,3),
('84066212881','Março','Nordeste','Feminino',70,2),
('84069801622','Fevereiro','Sudeste','Feminino',25,1),
('84081852013','Março','Sul','Feminino',35,2),
('84343382231','Fevereiro','Sudeste','Feminino',61,3),
('84523135324','Março','Centro-Oeste','Feminino',12,1),
('84562407623','Março','Sudeste','Feminino',78,1),
('84573564433','Março','Sul','Masculino',1,2),
('84851620342','Janeiro','Sudeste','Feminino',11,2),
('84944420239','Março','Sul','Feminino',19,3),
('85241707143','Fevereiro','Norte','Masculino',52,3),
('85409447368','Fevereiro','Sudeste','Feminino',0,3),
('85532786848','Março','Sul','Feminino',31,2),
('85639186039','Março','Sul','Feminino',32,2),
('85779255467','Março','Sul','Masculino',93,2),
('85822532660','Janeiro','Centro-Oeste','Masculino',39,1),
('86264159410','Fevereiro','Centro-Oeste','Masculino',62,3),
('86797420709','Março','Sul','Feminino',24,3),
('87039547468','Fevereiro','Sul','Masculino',41,3),
('87319206549','Janeiro','Sudeste','Masculino',49,3),
('87670889806','Fevereiro','Sul','Masculino',70,2),
('87995695013','Fevereiro','Nordeste','Feminino',42,3),
('88238883417','Janeiro','Sul','Masculino',63,3),
('88402935453','Janeiro','Centro-Oeste','Masculino',61,2),
('88780453810','Fevereiro','Nordeste','Feminino',25,2),
('89039416635','Fevereiro','Nordeste','Masculino',3,3),
('89207582016','Março','Sul','Masculino',92,1),
('89378074761','Janeiro','Centro-Oeste','Masculino',47,1),
('89381349170','Março','Nordeste','Feminino',12,3),
('89492943853','Janeiro','Sudeste','Feminino',22,2),
('89797588440','Fevereiro','Nordeste','Feminino',27,3),
('89888147734','Março','Sul','Masculino',66,2),
('90147673317','Fevereiro','Nordeste','Masculino',75,3),
('90308323158','Fevereiro','Nordeste','Feminino',46,3),
('90503392960','Janeiro','Centro-Oeste','Masculino',34,2),
('90508418367','Fevereiro','Sudeste','Masculino',26,1),
('90527864696','Março','Sul','Feminino',99,2),
('90561047554','Fevereiro','Sudeste','Masculino',85,2),
('91045318251','Janeiro','Centro-Oeste','Feminino',43,2),
('91126168345','Março','Sul','Masculino',91,1),
('91183919576','Janeiro','Nordeste','Masculino',39,1),
('91483131899','Março','Centro-Oeste','Masculino',81,2),
('91621368123','Janeiro','Sul','Masculino',56,1),
('91800054011','Março','Centro-Oeste','Masculino',4,3),
('92127151389','Janeiro','Sudeste','Feminino',36,1),
('92245965128','Fevereiro','Norte','Masculino',36,2),
('92539547515','Março','Nordeste','Masculino',10,3),
('92629073288','Março','Norte','Feminino',85,3),
('93106995221','Março','Sul','Masculino',34,1),
('93164408359','Janeiro','Nordeste','Masculino',97,3),
('93267240487','Março','Centro-Oeste','Feminino',29,3),
('93455906362','Janeiro','Sul','Feminino',83,2),
('94067131876','Fevereiro','Nordeste','Feminino',56,2),
('94547387656','Fevereiro','Sudeste','Feminino',46,2),
('94807894071','Março','Nordeste','Masculino',78,3),
('95036223162','Janeiro','Sul','Masculino',4,1),
('95036223162','Março','Sul','Masculino',4,2),
('95036223162','Fevereiro','Sul','Masculino',4,3),
('95270402807','Janeiro','Sul','Masculino',54,3),
('95270402807','Março','Sul','Masculino',54,3),
('95477220597','Fevereiro','Norte','Feminino',6,2),
('95810523324','Fevereiro','Sul','Feminino',14,2),
('95842091533','Janeiro','Nordeste','Masculino',83,2),
('96011908791','Fevereiro','Sul','Masculino',46,3),
('96038510456','Janeiro','Sudeste','Feminino',62,3),
('96918365181','Janeiro','Sul','Feminino',16,3),
('96972347995','Fevereiro','Centro-Oeste','Masculino',34,1),
('97228641676','Fevereiro','Nordeste','Feminino',84,3),
('97294369856','Março','Nordeste','Feminino',37,3),
('97637435622','Março','Sul','Feminino',9,1),
('97638466730','Janeiro','Sul','Masculino',27,1),
('97644474020','Março','Sudeste','Feminino',70,1),
('97798076236','Fevereiro','Norte','Feminino',97,3),
('97878280263','Março','Sudeste','Masculino',2,3),
('98037006006','Fevereiro','Norte','Feminino',47,2),
('98153178653','Fevereiro','Sul','Masculino',86,1),
('98513761298','Fevereiro','Norte','Feminino',91,2),
('98609973841','Março','Sudeste','Feminino',72,2),
('98643530757','Fevereiro','Centro-Oeste','Feminino',5,3);
```
# 3 - Diagrama de classes

O diagrama de classes é bem simples, a partir da base de dados coletada, pude definir que o sistema terá somente duas classes que se relacionam entre si. 
Abaixo uma imagem do diagrama de classes:

![image](https://user-images.githubusercontent.com/100853329/172007034-7520ef99-f2d4-4687-ac36-846592399ee6.png)

## Contextualização da imagem acima
- Para cada entidade, haverá um objeto responsável por fazer acesso a dados relacionado a sua entidade. Por exemplo:
	- Doenca: DoencaDao
	- Pessoa: PessoaDao
- Cada DAO será definido por uma interface.
- A injeção de dependência foi pensada por meio do padrão de projeto Factory.

# 4 - Persistência dos dados
Como explicado no diagrama de classes acima, o projeto foi desenhado no padrão DAO, porém as classes DAO's são interfaces, que implementa a interface é a tecnologia responsável pela manipulação dos dados com o banco, que no caso é o JDBC.

## com.br.fiap.enterprisechallenge.application
- Program: Teste das funcionalidades de CRUD da tb_pessoa
- Program2: Teste das funcionalidades de CRUD da tb_doenca

## com.br.fiap.enterprisechallenge.database
- DB: Connection and close connection do Statement, ResultSet e DataBase.
- DbException: Exceção do tipo RunTimeException para evitar de fazer tratamento da exceção SQLException.
- DbIntegrityException: Exceção do tipo RunTimeException, lançada apenas para casos de violação de integridade.

## com.br.fiap.enterprisechallenge.model.dao
- DaoFactory: Classe auxiliar contendo operações estaticas responsável por instanciar os Daos, para não precisar expor a implementação, somente deixando exposta a interface.
- DoencaDao: Interface contendo todos os paremetros utilizados pela implementação.
- PessoaDao: Interface contendo todos os paremetros utilizados pela implementação.

## com.br.fiap.enterprisechallenge.model.dao.impl
- DoencaDaoJDBC: Classe contendo todas as implementações da interface DoencaDao.
- PessoaDaoJDBC: Classe contendo todas as implementações da interface PessoaDao.

## com.br.fiap.enterprisechallenge.model.entites
- Doenca: Entidade doença contendo todos os atributos constituidos no diagrama de classes.
- Pessoa: Entidade pessoa contendo todos os atributos constituidos no diagrama de classes.

# 5 - Exemplo de três insights

