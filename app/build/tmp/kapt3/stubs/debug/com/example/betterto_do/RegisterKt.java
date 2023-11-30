package com.example.betterto_do;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a(\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0007\u001a\b\u0010\u000f\u001a\u00020\u0001H\u0007\u001aP\u0010\u0010\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00072\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\b\u0010\u0018\u001a\u00020\u0001H\u0007\u00a8\u0006\u0019"}, d2 = {"NewUserField", "", "value", "", "isPassword", "", "onValueChanged", "Lkotlin/Function1;", "RegisterButton", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "activity", "Lcom/example/betterto_do/Register;", "email", "password", "RegisterHeader", "RegisterScreen", "modifier", "Landroidx/compose/ui/Modifier;", "userCredentials", "Landroidx/compose/runtime/MutableState;", "Lcom/example/betterto_do/Register$UserCredentials;", "onEmailChanged", "onPasswordChanged", "ReturningUserButton", "app_debug"})
public final class RegisterKt {
    
    @androidx.compose.runtime.Composable
    public static final void RegisterScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<com.example.betterto_do.Register.UserCredentials> userCredentials, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onEmailChanged, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onPasswordChanged) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RegisterHeader() {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void NewUserField(@org.jetbrains.annotations.NotNull
    java.lang.String value, boolean isPassword, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChanged) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RegisterButton(@org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull
    com.example.betterto_do.Register activity, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void ReturningUserButton() {
    }
}