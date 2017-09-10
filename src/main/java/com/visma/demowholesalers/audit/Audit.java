package com.visma.demowholesalers.audit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation which indicates that a which method needs auditing
 * 
 * @author vmustafayev
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Audit {
	
	String value() default "";
	
	// We can add here any type of attributes like as RequestMapping annotation
}
