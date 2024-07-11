CREATE TABLE `newton_school_forum`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) CHARACTER SET 'utf8' COLLATE 'utf8_bin' NOT NULL,
  `firstname` VARCHAR(25) NOT NULL,
  `lastname` VARCHAR(25) NOT NULL,
  `email` VARCHAR(40) NOT NULL,
  `birthday` DATE NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `picture` VARCHAR(90) NULL DEFAULT 'profile_pictures/default_picture.jpg',
  `is_admin` TINYINT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);