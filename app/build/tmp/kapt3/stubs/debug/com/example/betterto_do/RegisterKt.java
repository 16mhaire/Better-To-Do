package com.example.betterto_do;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0007H\u0007\u001a\u0018\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\b\u0010\r\u001a\u00020\u0001H\u0007\u001a\b\u0010\u000e\u001a\u00020\u0001H\u0007\u001a\u001a\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006\u0012"}, d2 = {"NewUserField", "", "value", "", "isPassword", "", "onValueChanged", "Lkotlin/Function1;", "RegisterButton", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "activity", "Lcom/example/betterto_do/Register;", "RegisterHeader", "RegisterPreview", "RegisterScreen", "modifier", "Landroidx/compose/ui/Modifier;", "app_debug"})
public final class RegisterKt {
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true)
    @androidx.compose.runtime.Composable
    public static final void RegisterPreview() {
    }
    
    @androidx.compose.runtime.Composable
    public static final void RegisterScreen(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier modifier, @org.jetbrains.annotations.NotNull
    com.google.firebase.auth.FirebaseAuth auth) {
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
    com.example.betterto_do.Register activity) {
    }
}