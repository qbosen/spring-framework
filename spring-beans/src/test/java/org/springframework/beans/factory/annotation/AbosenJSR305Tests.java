package org.springframework.beans.factory.annotation;

import org.junit.jupiter.api.Test;
import org.springframework.lang.NonNull;

import java.lang.annotation.Annotation;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author qiubaisen
 * @date 2019/12/16
 */
public class AbosenJSR305Tests {
	@Test
	public void testTypeQualifierNicknameAnnotation() throws NoSuchFieldException {
		Annotation[] annotations = AbosenJSR305Tests.class.getDeclaredField("object").getAnnotations();
		assertThat(annotations.length).isEqualTo(1);
		// 说明javax.annotation.* 注解的处理是由具体插件支持的，javaSE 本身不支持
		assertThat(annotations[0]).isInstanceOf(NonNull.class);
	}

	// jetbrains IDE 支持 JSR305
	@NonNull
	private Object object;
}
