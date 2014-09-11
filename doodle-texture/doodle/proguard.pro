-verbose
-dontshrink
-dontoptimize
-dontobfuscate

-keep public class  com.googlecode.javacpp.Loader{
 *;
}

-keep public class * extends com.googlecode.javacpp.Pointer{
 *;
}

-keep public class  org.ccj.Engine{
 *;
}

-keepclasseswithmembernames class * {
    native <methods>;
}

-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

