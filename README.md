# DIDOMODZ APK BUILDER v2

Versão inicial funcional para compilar um APK Android personalizado usando GitHub Actions, pelo celular.

## O que esta versão faz
- Recebe o nome do app e a URL HTTPS no formulário manual do GitHub Actions.
- Atualiza o nome exibido no Android e o site que abre dentro do app.
- Compila um APK de debug e publica o arquivo como artefato para baixar.
- Inclui um painel web demonstrativo em `web/`.

## Limites
- O identificador do pacote fica fixo em `com.didomodz.apkbuilder` nesta versão para manter o processo simples e confiável.
- A personalização é informada na tela do GitHub Actions; o formulário do site ainda não dispara a compilação diretamente.
- O APK é de debug para testes. Para publicar na Play Store será necessário configurar assinatura de release e revisar requisitos atuais da loja.
- Use apenas sites próprios ou para os quais tenha autorização.
- O GitHub pode impor limites de uso ao Actions conforme o tipo de conta e repositório.

## Configurar pelo celular
1. Crie um repositório no GitHub, por exemplo `didomodz-apk-builder`.
2. Extraia este ZIP no telefone.
3. Envie todos os arquivos e pastas para a raiz do repositório, mantendo os caminhos.
   - No app/site GitHub pelo navegador, você pode usar **Add file > Upload files**. Se o envio de pastas for difícil no celular, envie os arquivos mantendo a estrutura; alternativamente use Termux com Git.
4. Abra o repositório e toque em **Actions**.
5. Se aparecer uma mensagem para habilitar workflows, habilite-os.
6. Escolha **Build Personalized APK** > **Run workflow**.
7. Preencha:
   - `app_name`: nome a mostrar no Android
   - `site_url`: URL HTTPS do site que o APK abrirá
8. Toque em **Run workflow** e espere a execução terminar com marca verde.
9. Abra a execução concluída, encontre **Artifacts** e baixe `didomodz-apk`.
10. Extraia o ZIP do artefato e instale o APK. O Android pode pedir autorização para instalar apps dessa origem.

## Testar o painel
Abra `web/index.html` no SPCK Editor. O painel valida e mostra os dados, mas não aciona GitHub Actions automaticamente; essa integração direta precisaria de um backend seguro ou de um fluxo autenticado separado. Nunca coloque um token do GitHub no JavaScript do site.
