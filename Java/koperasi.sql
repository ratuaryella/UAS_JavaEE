/*
SQLyog Ultimate v8.55 
MySQL - 5.5.5-10.1.38-MariaDB : Database - koperasi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`koperasi` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `koperasi`;

/*Table structure for table `jasa_pengiriman` */

DROP TABLE IF EXISTS `jasa_pengiriman`;

CREATE TABLE `jasa_pengiriman` (
  `paket_id` int(11) NOT NULL AUTO_INCREMENT,
  `email_pengirim` varchar(100) NOT NULL,
  `alamat_pengirim` varchar(200) NOT NULL,
  `nama_paket` varchar(30) NOT NULL,
  `alamat_tujuan` varchar(200) NOT NULL,
  `telp_penerima` varchar(20) NOT NULL,
  `deskripsi_pengiriman` varchar(200) NOT NULL,
  `harga_pengiriman` int(11) NOT NULL,
  `status_pembayaran` int(11) NOT NULL,
  `tanggal_pengiriman` date NOT NULL,
  `tanggal_pembayaran` date NOT NULL,
  PRIMARY KEY (`paket_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `jasa_pengiriman` */

/*Table structure for table `pembayaran_produk` */

DROP TABLE IF EXISTS `pembayaran_produk`;

CREATE TABLE `pembayaran_produk` (
  `pembayaran_id` int(11) NOT NULL AUTO_INCREMENT,
  `produk_id` int(11) NOT NULL,
  `email_pemesan` varchar(100) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `status_pembayaran` int(11) NOT NULL,
  `tanggal_bayar` date NOT NULL,
  `harga_total` int(11) NOT NULL,
  `email_user` varchar(100) NOT NULL,
  PRIMARY KEY (`pembayaran_id`),
  KEY `FK_pembayaran_produk` (`produk_id`),
  CONSTRAINT `FK_pembayaran_produk` FOREIGN KEY (`produk_id`) REFERENCES `produk` (`produk_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pembayaran_produk` */

/*Table structure for table `produk` */

DROP TABLE IF EXISTS `produk`;

CREATE TABLE `produk` (
  `produk_id` int(11) NOT NULL AUTO_INCREMENT,
  `nama_produk` varchar(30) NOT NULL,
  `jenis_produk` varchar(30) NOT NULL,
  `deskripsi_produk` varchar(30) NOT NULL,
  `harga` int(11) NOT NULL,
  `stok` int(10) NOT NULL,
  PRIMARY KEY (`produk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `produk` */

insert  into `produk`(`produk_id`,`nama_produk`,`jenis_produk`,`deskripsi_produk`,`harga`,`stok`) values (5,'Oreo Mix','Makanan','200gr, rasa coklat',21000,100),(9,'Biskuit Roma','Makanan','Gurih dan Sedap',8000,119),(10,'Aqua','Meinuman','Minuman 200 ml',3000,20);

/*Table structure for table `pulsa` */

DROP TABLE IF EXISTS `pulsa`;

CREATE TABLE `pulsa` (
  `pulsa_id` int(11) NOT NULL AUTO_INCREMENT,
  `jumlah_pulsa` int(11) NOT NULL,
  `nomor_pengisian` varchar(12) NOT NULL,
  `tanggal_pemesanan` date NOT NULL,
  `status` int(1) NOT NULL,
  `tanggal_pembayaran` date NOT NULL,
  `email_pengirim` varchar(100) NOT NULL,
  `harga` int(12) NOT NULL,
  PRIMARY KEY (`pulsa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

/*Data for the table `pulsa` */

insert  into `pulsa`(`pulsa_id`,`jumlah_pulsa`,`nomor_pengisian`,`tanggal_pemesanan`,`status`,`tanggal_pembayaran`,`email_pengirim`,`harga`) values (2,75000,'0812313123','2021-01-20',0,'0000-00-00','',77000),(19,0,'','2021-01-21',0,'0000-00-00','',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
