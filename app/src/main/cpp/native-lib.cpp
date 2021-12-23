#include <jni.h>
#include <string>
#include "Expression.h"

extern "C"
JNIEXPORT jstring JNICALL
Java_me_bkkn_gb_1android1_1project2_1calculator_model_Expression_stringFromJNI(JNIEnv *env,
                                                                               jobject thiz,
                                                                               jstring jinput) {
    const jsize len = (*env).GetStringLength(jinput);
    jboolean isCopy;
    const char *convertedValue = (env)->GetStringUTFChars(jinput, &isCopy);
    std::string output = std::string(convertedValue, len);

//    std::string output = "Hello from C++";
    std::string expression(convertedValue);

    double result = Calculate(expression);
    output = std::to_string(result);

//    Expression *pExpression = CreateExpression(expression);
//    const double result = CalculateExpression(pExpression);
//    DisposeExpression(pExpression);

    return env->NewStringUTF(output.c_str());
}