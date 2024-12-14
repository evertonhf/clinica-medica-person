-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 14-Dez-2024 às 00:45
-- Versão do servidor: 8.0.31
-- versão do PHP: 7.4.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `clinica_medica`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

DROP TABLE IF EXISTS `consulta`;
CREATE TABLE IF NOT EXISTS `consulta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `dataHorario` datetime NOT NULL,
  `sintomas` varchar(255) COLLATE utf16_swedish_ci DEFAULT NULL,
  `eRetorno` tinyint(1) NOT NULL,
  `estaAtiva` tinyint(1) NOT NULL,
  `convenio_id` int DEFAULT NULL,
  `prontuario_id` int NOT NULL,
  `atendente_id` int NOT NULL,
  `medico_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_swedish_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `convenio`
--

DROP TABLE IF EXISTS `convenio`;
CREATE TABLE IF NOT EXISTS `convenio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf16_swedish_ci NOT NULL,
  `descricao` text COLLATE utf16_swedish_ci,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_swedish_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `especialidade`
--

DROP TABLE IF EXISTS `especialidade`;
CREATE TABLE IF NOT EXISTS `especialidade` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf16_swedish_ci NOT NULL,
  `descricao` text COLLATE utf16_swedish_ci,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_swedish_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) COLLATE utf16_swedish_ci NOT NULL,
  `senha` int NOT NULL,
  `nome` varchar(100) COLLATE utf16_swedish_ci NOT NULL,
  `idade` int NOT NULL,
  `sexo` char(1) COLLATE utf16_swedish_ci NOT NULL,
  `cpf` varchar(14) COLLATE utf16_swedish_ci NOT NULL,
  `rua` varchar(100) COLLATE utf16_swedish_ci DEFAULT NULL,
  `numero` varchar(10) COLLATE utf16_swedish_ci DEFAULT NULL,
  `complemento` varchar(50) COLLATE utf16_swedish_ci DEFAULT NULL,
  `bairro` varchar(50) COLLATE utf16_swedish_ci DEFAULT NULL,
  `cidade` varchar(50) COLLATE utf16_swedish_ci DEFAULT NULL,
  `estado` varchar(50) COLLATE utf16_swedish_ci DEFAULT NULL,
  `contato` varchar(15) COLLATE utf16_swedish_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf16_swedish_ci DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `perfil_id` int NOT NULL,
  `especialidade_id` int DEFAULT NULL,
  `tipo_funcionario` varchar(45) COLLATE utf16_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_swedish_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

DROP TABLE IF EXISTS `paciente`;
CREATE TABLE IF NOT EXISTS `paciente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) COLLATE utf16_swedish_ci NOT NULL,
  `idade` int NOT NULL,
  `sexo` char(1) COLLATE utf16_swedish_ci NOT NULL,
  `cpf` varchar(14) COLLATE utf16_swedish_ci NOT NULL,
  `rua` varchar(100) COLLATE utf16_swedish_ci DEFAULT NULL,
  `numero` varchar(10) COLLATE utf16_swedish_ci DEFAULT NULL,
  `complemento` varchar(50) COLLATE utf16_swedish_ci DEFAULT NULL,
  `bairro` varchar(50) COLLATE utf16_swedish_ci DEFAULT NULL,
  `cidade` varchar(50) COLLATE utf16_swedish_ci DEFAULT NULL,
  `estado` varchar(50) COLLATE utf16_swedish_ci DEFAULT NULL,
  `contato` varchar(15) COLLATE utf16_swedish_ci DEFAULT NULL,
  `email` varchar(100) COLLATE utf16_swedish_ci DEFAULT NULL,
  `dataNascimento` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_swedish_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `perfil`
--

DROP TABLE IF EXISTS `perfil`;
CREATE TABLE IF NOT EXISTS `perfil` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) COLLATE utf16_swedish_ci NOT NULL,
  `cadastrarFuncionario` tinyint(1) NOT NULL,
  `lerFuncionario` tinyint(1) NOT NULL,
  `atualizarFuncionario` tinyint(1) NOT NULL,
  `deletarFuncionario` tinyint(1) NOT NULL,
  `listarFuncionario` tinyint(1) NOT NULL,
  `cadastrarPaciente` tinyint(1) NOT NULL,
  `lerPaciente` tinyint(1) NOT NULL,
  `atualizarPaciente` tinyint(1) NOT NULL,
  `deletarPaciente` tinyint(1) NOT NULL,
  `listarPaciente` tinyint(1) NOT NULL,
  `cadastrarConsulta` tinyint(1) NOT NULL,
  `lerConsulta` tinyint(1) NOT NULL,
  `atualizarConsulta` tinyint(1) NOT NULL,
  `deletarConsulta` tinyint(1) NOT NULL,
  `listarConsulta` tinyint(1) NOT NULL,
  `cadastrarEspecialidade` tinyint(1) NOT NULL,
  `lerEspecialidade` tinyint(1) NOT NULL,
  `atualizarEspecialidade` tinyint(1) NOT NULL,
  `deletarEspecialidade` tinyint(1) NOT NULL,
  `listarEspecialidade` tinyint(1) NOT NULL,
  `cadastrarConvenio` tinyint(1) NOT NULL,
  `lerConvenio` tinyint(1) NOT NULL,
  `atualizarConvenio` tinyint(1) NOT NULL,
  `deletarConvenio` tinyint(1) NOT NULL,
  `listarConvenio` tinyint(1) NOT NULL,
  `cadastrarProntuario` tinyint(1) NOT NULL,
  `lerProntuario` tinyint(1) NOT NULL,
  `atualizarProntuario` tinyint(1) NOT NULL,
  `deletarProntuario` tinyint(1) NOT NULL,
  `listarProntuario` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_swedish_ci;

-- --------------------------------------------------------

--
-- Estrutura da tabela `prontuario`
--

DROP TABLE IF EXISTS `prontuario`;
CREATE TABLE IF NOT EXISTS `prontuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `receituario` text COLLATE utf16_swedish_ci,
  `exames` text COLLATE utf16_swedish_ci,
  `observacoes` varchar(255) COLLATE utf16_swedish_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf16 COLLATE=utf16_swedish_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
