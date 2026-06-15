// Espera o site carregar
document.addEventListener("DOMContentLoaded", function () {

    // =========================
    // BOTÃO "MINHA CONTA"
    // =========================
    const btnLogin = document.querySelector(".btn-login");

    if (btnLogin) {
        btnLogin.addEventListener("click", function () {
            window.location.href = "login.html";
        });
    }

    // =========================
    // BOTÃO "ENTRAR" (LOGIN)
    // =========================
    const btnEntrar = document.querySelector("button");

    if (btnEntrar && window.location.pathname.includes("login.html")) {
        btnEntrar.addEventListener("click", function () {
            alert("Login realizado com sucesso!");
            window.location.href = "index.html";
        });
    }

    // =========================
    // BOTÃO "EXPLORAR"
    // =========================
    const btnExplorar = document.querySelector(".btn-cta");

    if (btnExplorar) {
        btnExplorar.addEventListener("click", function () {
            window.scrollTo({
                top: document.body.scrollHeight,
                behavior: "smooth"
            });
        });
    }

    // =========================
    // LINKS QUE NÃO FAZEM NADA (#)
    // =========================
    const links = document.querySelectorAll('a[href="#"]');

    links.forEach(link => {
        link.addEventListener("click", function (e) {
            e.preventDefault();
            alert("Essa funcionalidade ainda será implementada 😉");
        });
    });

});