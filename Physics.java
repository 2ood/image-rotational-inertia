/**
Program of GUI for rotational inertia from image shapes.

@author Kyungmin, Choi, KMLA (kyungmin.official0@gmail.com)
@language java
*/

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Physics extends GUIFrame implements TextListener,ActionListener {
  java.awt.Label lb1;
  java.awt.Button simulate;
  java.awt.Button reload;
  java.awt.TextField tf3;
  java.awt.TextArea tf2;
  BufferedImage image;
  File file;
  Canvas canv;
  String number = "1000";
  Graphics g;
  String fileName="CircleFrame.png";
  ImageObserver observer;

  public static void main(String [] args) {
    new Physics();
  }

  public Physics() {
    super("Physics Test");
    setSize(500, 700);

    lb1 = new java.awt.Label("Enter the shape's name");
    add(lb1);

    tf3 = new java.awt.TextField("CircleFrame.png", 20);
    tf3.addTextListener(this);
    add(tf3);

    simulate = new java.awt.Button("Simulate");
    simulate.addActionListener(this);
    add(simulate);

    reload = new java.awt.Button("Reload");
    reload.addActionListener(this);
    add(reload);

    canv = new Canvas();
    canv.setSize(410, 410);
    canv.setBackground(Color.WHITE);
    add(canv, "South");

    tf2 = new java.awt.TextArea("[ Area : 0 ][ Rot.Inertia : 0 ]", 2, 40, 3);
    tf2.setSize(500, 30);
    add(tf2,"South");

    observer= new JFrame();
    try{
      loadOrFail(fileName);
    } catch(Exception e) { ;}

    setLayout(new java.awt.FlowLayout());
    setVisible(true);
  }

  public void textValueChanged(java.awt.event.TextEvent paramTextEvent) {
    if(paramTextEvent.getSource()==tf3) {
      Object localObject = paramTextEvent.getSource();
      fileName=((java.awt.TextComponent)localObject).getText();

      try{
        loadOrFail(fileName);
      } catch(Exception e) { ;}
    }
  }
  public void actionPerformed(java.awt.event.ActionEvent paramActionEvent) {
    if (paramActionEvent.getSource() == simulate) doIt();
    if (paramActionEvent.getSource() == reload) reload();
  }

  public void reload() {
    g=canv.getGraphics();
    canv.paint(g);
    g.drawImage(image,0,0,observer);
    setVisible(true);
  }

  public void doIt() {
    int i = Integer.parseInt(number);
    System.out.println(i);
    g = canv.getGraphics();
    canv.paint(g);
    g.setColor(Color.BLUE);
    Color t ;int j = 0; double k=0D;
    for (int m=0; m<400; m++) {
      for(int n=0;n<400;n++) {
        if(image.getRGB(m,n)==Color.BLACK.getRGB()) {
          j++;
          k+=(n-200)*(n-200);
          g.fillOval(m,n,2,2);
        }
      }
    }

    java.util.Random localRandom = new java.util.Random();
    int l =160000 ;
    double area=(double)(j)/l;
    double inertia=k;
    double factor = area/inertia;
    tf2.setText("[Area : "+area+"], [Rotational Inertia :"+inertia+"] \n[factor :"+factor+"]");
    //reload();
  }

  public void loadOrFail(String fileName) throws IOException {
    this.fileName = fileName;
    File file = new File(this.fileName);
    try{
      image = ImageIO.read(file);
    } catch(Exception e) {
      throw new IOException();
    }
  }
}
