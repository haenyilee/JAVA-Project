package com.sist.client;
import java.util.*;
import com.sist.data.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class MusicForm extends JPanel implements ActionListener{
   JButton b1,b2;
   JLabel la;
   int curpage=1;
   JPanel p=new JPanel();
   public MusicForm()
   {
	   setLayout(new BorderLayout());
	   MusicManager m=new MusicManager();
	   
   	   //p.setLayout(null);
   	   JScrollPane pp=new JScrollPane();
   	   Dimension size = new Dimension();//����� �����ϱ� ���� ��ü ����
   	   size.setSize(1000, 1000);//��ü�� ����� ����
   	   p.setPreferredSize(size);//������ ������ ������ �ִ� ��ü�� �̿��� �г��� ������ ����
   	   pp.setViewportView(p);
	   ArrayList<MusicVO> music=m.musicListData(1);
	   p.setLayout(new GridLayout(5, 1));
	   
	   for(MusicVO vo:music)
	   {
		   MusicCard nc=new MusicCard();
		   nc.musicPrint(vo);
		   p.add(nc);
	   }
	   add("Center",pp);
	   b1=new JButton("����");
	   b2=new JButton("����");
	   la=new JLabel("1 page / 11 pages");
	   JPanel ppp=new JPanel();
	   ppp.add(b1); ppp.add(la); ppp.add(b2);
	   add("South",ppp);
	   
	   b1.addActionListener(this);
	   b2.addActionListener(this);
	   
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			if(curpage>1)
			{
				   curpage--;
				   MusicManager m=new MusicManager();
				   ArrayList<MusicVO> music=m.musicListData(curpage);
				   p.removeAll();
				   for(MusicVO vo:music)
				   {
					   MusicCard nc=new MusicCard();
					   nc.musicPrint(vo);
					   p.add(nc);
				   }
				   p.validate();
			}
		}
		else if(e.getSource()==b2)
		{
			if(curpage<11)
			{
				   curpage++;
				   MusicManager m=new MusicManager();
				   ArrayList<MusicVO> music=m.musicListData(curpage);
				   p.removeAll();
				   for(MusicVO vo:music)
				   {
					   MusicCard nc=new MusicCard();
					   nc.musicPrint(vo);
					   p.add(nc);
				   }
				   p.validate();
			}
		}
		la.setText(curpage+" page / 11 pages");
	}
}