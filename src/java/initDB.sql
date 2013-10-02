/*==============================================================*/
/*==      Inicijalizacija MySql DB web aplikacije Konzul      ==*/
/*==============================================================*/


/*==============================================================*/
/* Table: Korisnik                                              */
/*==============================================================*/
create table Korisnik
(
   KorisnikId           int AUTO_INCREMENT not null,
   KorisnikIme          text not null,
   KorisnikPrezime      text not null,
   KorisnikPristupnoIme text not null,
   KorisnikLozinka      text,
   KorisnikRola         varchar(25) not null,
   primary key (KorisnikId)
);

/*==============================================================*/
/* Table: Drzava                                                   */
/*==============================================================*/
create table Drzava
(
   DrzavaId                int AUTO_INCREMENT not null,
   DrzavaNaziv             text not null,
   primary key (DrzavaId)
);

/*==============================================================*/
/* Table: LicniStatus                                         */
/*==============================================================*/
create table LicniStatus
(
   LicniStatusId        int AUTO_INCREMENT not null,
   LicniStatusOpis      text not null,
   primary key (LicniStatusId)
);

/*==============================================================*/
/* Table: Status                                         */
/*==============================================================*/
create table Status
(
   StatusId        int AUTO_INCREMENT not null,
   StatusOpis      text not null,
   primary key (StatusId)
);

/*==============================================================*/
/* Table: Zahtev                                                */
/*==============================================================*/
create table Zahtev
(
   ZahtevId             int AUTO_INCREMENT not null,
   ZahtevDatum          date not null default 0,
   ZahtevIme            text not null,
   ZahtevPrezime        text not null,
   ZahtevImeOca         text,
   ZahtevImeMajke       text,
   ZahtevDevojackoPrezimeMajke text,
   ZahtevDatumRodjenja  date not null,
   ZahtevMestoRodjenja  text not null,
   ZahtevDrzavaRodjenjaId int,
   ZahtevZanimanje      text,
   ZahtevSkolskaSprema  text,
   ZahtevMestoNastanjenja   text,
   ZahtevDrzavaIseljenjaId  int,
   ZahtevStranoDrzavljanstvoId  int,
   ZahtevVO             text,
   ZahtevZaposlenje     text,
   ZahtevMaterijalnoStanje  text,
   ZahtevLicniStatusId  int,
   ZahtevBracniDrug     text,
   ZahtevOsudjivan      text,
   ZahtevStaraoc        text,
   ZahtevKorisnikId     int not null,
   ZahtevStatusId       int not null,
   primary key (ZahtevId)

);
alter table Zahtev add constraint FK_ZahtevDrzavaRodjenja foreign key (ZahtevDrzavaRodjenjaId)
      references Drzava (DrzavaId) on delete restrict on update restrict;
alter table Zahtev add constraint FK_ZahtevDrzavaIseljenja foreign key (ZahtevDrzavaIseljenjaId)
      references Drzava (DrzavaId) on delete restrict on update restrict;
alter table Zahtev add constraint FK_ZahtevStranoDrzavljanstvo foreign key (ZahtevStranoDrzavljanstvoId)
      references Drzava (DrzavaId) on delete restrict on update restrict;
alter table Zahtev add constraint FK_ZahtevLicniStatus foreign key (ZahtevLicniStatusId)
      references LicniStatus (LicniStatusId) on delete restrict on update restrict;
alter table Zahtev add constraint FK_ZahtevKorisnik foreign key (ZahtevKorisnikId)
      references Korisnik (KorisnikId) on delete restrict on update restrict;
alter table Zahtev add constraint FK_ZahtevStatus foreign key (ZahtevStatusId)
      references Status (StatusId) on delete restrict on update restrict;


insert INTO LicniStatus (LicniStatusOpis) VALUES ('sam-a');
insert INTO LicniStatus (LicniStatusOpis) VALUES ('u braku');
insert INTO LicniStatus (LicniStatusOpis) VALUES ('razveden-a');
insert INTO LicniStatus (LicniStatusOpis) VALUES ('udovac-ica');

insert INTO Status (StatusOpis) VALUES ('aktivan');
insert INTO Status (StatusOpis) VALUES ('pasivan');

insert INTO Korisnik (KorisnikIme,KorisnikPrezime,KorisnikPristupnoIme,KorisnikLozinka,KorisnikRola) 
    VALUES ('admin','admin','admin','admin','ADMIN');
insert INTO Korisnik (KorisnikIme,KorisnikPrezime,KorisnikPristupnoIme,KorisnikLozinka,KorisnikRola) 
    VALUES ('user','user','user','user','USER');
insert INTO Korisnik (KorisnikIme,KorisnikPrezime,KorisnikPristupnoIme,KorisnikLozinka,KorisnikRola) 
    VALUES ('Konzul','Konzul','konzul','konzul123','KONZUL');