����   < �  )modul1/PRAK101_2310817220011_ReginaSilvaM  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this +Lmodul1/PRAK101_2310817220011_ReginaSilvaM; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V  java/lang/String  Januari   Februari " Maret $ April & Mei ( Juni * Juli , Agustus . 	September 0 Oktober 2 November 4 Desember	  6 7 8 out Ljava/io/PrintStream; : Masukkan Nama Lengkap : 
 < > = java/io/PrintStream ? @ print (Ljava/lang/String;)V
  B C D nextLine ()Ljava/lang/String; F Masukkan Tempat Lahir :  H Masukkan Tanggal Lahir : 
  J K L nextInt ()I N Masukkan Bulan Lahir :  P Masukkan Tahun Lahir :  R Masukkan Tinggi Badan :  T Masukkan Berat Badan : 
  V W X 
nextDouble ()D Z java/lang/StringBuilder \ Nama Lengkap 
 Y ^  @
 Y ` a b append -(Ljava/lang/String;)Ljava/lang/StringBuilder; d , Lahir di  f  pada Tanggal 
 Y h a i (I)Ljava/lang/StringBuilder; k  
 Y m n D toString
 < p q @ println s Tinggi Badan  u  cm dan Berat Badan 
 Y w a x (D)Ljava/lang/StringBuilder; z 	 kilogram
  | }  close args [Ljava/lang/String; input Ljava/util/Scanner; bulan nama Ljava/lang/String; tempatlahir lahirtanggal I 
lahirbulan 
lahirtahun tb bb D 
SourceFile 'PRAK101_2310817220011_ReginaSilvaM.java !               /     *� �    
                    	      �    !� Y� � L� YSYSY!SY#SY%SY'SY)SY+SY-SY	/SY
1SY3SM� 59� ;+� AN� 5E� ;+� A:� 5G� ;+� I6� 5M� ;+� I6� 5O� ;+� I6� 5Q� ;+� I6� 5S� ;+� U9	� 5� YY[� ]-� _c� _� _e� _� gj� _,d2� _j� _� g� l� o� 5� YYr� ]� gt� _	� vy� _� l� o+� {�    
   R      
 S  [  `  h  n  v  |  �  �  �  �  �  �  �  � " � # %  &    f 
  ! ~     � �  S � �   ` � � �  n � � �  | � � �  � � � �  � � � �  � { � �  � m � � 	  �    �