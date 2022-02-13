package com.study.springcore.aop_lab;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class Introducter { //經紀人
	//將Performance 及其子類別轉化為Singer
	@DeclareParents(value = "com.study.springcore.aop_lab.Performance+",
			defaultImpl = BackSinger.class)
	public Singer singer;
	
	@DeclareParents(value = "com.study.springcore.aop_lab.Performance+",
			defaultImpl = TalkActor.class)
	public Actor actor;
	
	

}
