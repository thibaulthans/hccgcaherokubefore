DROP TABLE IF EXISTS `recrutement`;
CREATE TABLE `recrutement` 
(
	`idRecrutement`  INT NOT NULL AUTO_INCREMENT,
	`prenom`  VARCHAR(100) NOT NULL,
	`nom` VARCHAR(100) NOT NULL,
    `mail`  VARCHAR(100) NOT NULL,
	`formation` VARCHAR(100) NOT NULL,
    `posteRecherche` VARCHAR(100) NOT NULL,
    `cv` VARCHAR(100) NOT NULL,
    `lettreMotivation` VARCHAR(100) NOT NULL,
	PRIMARY KEY (`idRecrutement`)
)DEFAULT CHARSET=utf8;
    
DROP TABLE IF EXISTS `devis`;
CREATE TABLE `devis` 
(
	`idDevis`  INT NOT NULL AUTO_INCREMENT,
	`secteurActivite`  VARCHAR(100) NOT NULL,
	`chiffreAffaire` VARCHAR(100) NOT NULL,
    `nbSalarie`  VARCHAR(100) NOT NULL,
	`missions` VARCHAR(100) NOT NULL,
    `valeurFacture`  MEDIUMINT(9) NOT NULL,
	`nom` VARCHAR(100) NOT NULL,
	`prenom` VARCHAR(100) NOT NULL,
    `mail`  VARCHAR(100) NOT NULL,
	`informationsSupplementaires` VARCHAR(2000) NOT NULL, /*MEDIUMTEXT NOT NULL, */
	PRIMARY KEY (`idDevis`)
)DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact` 
(
	`idContact`  INT NOT NULL AUTO_INCREMENT,
	`nom` VARCHAR(100) NOT NULL,
    `mail`  VARCHAR(100) NOT NULL,
	`objet` VARCHAR(100) NOT NULL,
    `message` VARCHAR(2000) NOT NULL,
	PRIMARY KEY (`idContact`)
)DEFAULT CHARSET=utf8;
