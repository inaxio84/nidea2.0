/*
	Operaciones CRUD
*/

-- Listar materiales

SELECT `id`, `nombre`, `precio` FROM `material` ORDER BY `id` DESC LIMIT 500;

-- Buscar materiales

SELECT `id`, `nombre`, `precio` FROM `material` WHERE `nombre` LIKE '%ja%' ORDER BY `id` DESC LIMIT 500;

-- Detalle

SELECT `id`, `nombre`, `precio` FROM `material` WHERE `id`=8;

-- Update

UPDATE `nidea`.`material` SET `nombre`='birra', `precio`=3.45 WHERE  `id`=8;

-- Delete

DELETE FROM `nidea`.`material` WHERE  `id`=8;

-- Create

INSERT INTO `nidea`.`material` (`nombre`, `precio`) VALUES ('birra', '2');

