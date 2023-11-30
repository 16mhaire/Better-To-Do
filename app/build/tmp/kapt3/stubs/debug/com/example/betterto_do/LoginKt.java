package com.example.betterto_do;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\b\u0010\u0004\u001a\u00020\u0001H\u0007\u001a(\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007\u001a\b\u0010\u000b\u001a\u00020\u0001H\u0007\u001a,\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u0012H\u0007\u00a8\u0006\u0013"}, d2 = {"LoginButton", "", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "LoginHeading", "LoginScreen", "modifier", "Landroidx/compose/ui/Modifier;", "userCredentials", "Landroidx/compose/runtime/MutableState;", "Lcom/example/betterto_do/Register$UserCredentials;", "NewUserButton", "TextInputField", "value", "", "isPassword", "", "onValueChanged", "Lkotlin/Function1;", "app_debug"})
public final class LoginKt {
    
    @androidx.compose.runtime.Composable
    public static final void LoginScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull
    androidx.compose.runtime.MutableState<com.example.betterto_do.Register.UserCredentials> userCredentials) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void LoginHeading() {
    }
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable
    public static final void TextInputField(@org.jetbrains.annotations.NotNull
    java.lang.String value, boolean isPassword, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onValueChanged) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void LoginButton(@org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth auth) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void NewUserButton() {
    }
}