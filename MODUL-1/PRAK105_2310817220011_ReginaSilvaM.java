����   < \  )modul1/PRAK105_2310817220011_ReginaSilvaM  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this +Lmodul1/PRAK105_2310817220011_ReginaSilvaM; main ([Ljava/lang/String;)V@	�Q�  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	      out Ljava/io/PrintStream; " Masukkan jari-jari: 
 $ & % java/io/PrintStream ' ( print (Ljava/lang/String;)V
  * + , 
nextDouble ()D . Masukkan tinggi: @       @       4 ?
 $ 6 7 ( println
 9 ; : java/lang/Math < = pow (DD)D ? -Volume tabung dengan jari-jari %.1f cm dan %n
 A C B java/lang/Double D E valueOf (D)Ljava/lang/Double;
 $ G H I printf <(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream; K tinggi %.1f cm adalah %.3f m3%n
  M N  close args [Ljava/lang/String; phi D input Ljava/util/Scanner; jari2 tinggi vol StackMapTable P 
SourceFile 'PRAK105_2310817220011_ReginaSilvaM.java !               /     *� �    
                    	      ;  
   � H� Y� � N� !� #-� )9� -� #-� )9 /��  1�� � 3� 5� F  /� 8kk9� >� Y� @S� FW� J� Y� @SY� @S� FW-� L�    
   :        
     %  +  =  E  H  Y  n  �  �     >    � O P    � Q R   � S T   s U R  + e V R  Y 2 W R  X    � H  Y   � B  Z    [