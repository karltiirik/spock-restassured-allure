import groovy.transform.AnnotationCollector
import io.qameta.allure.Story
import io.qameta.allure.TmsLink

@AnnotationCollector([Story, TmsLink])
@interface Requirement {}