# CEP-Finder

API REST de consulta de endereço e cálculo de frete para um determinado CEP, utilizando da API [ViaCEP](https://viacep.com.br/).

- Para realizar uma consulta de um CEP específico, é necessário realizar uma requisição com o corpo:
  {
    "cep": "xxxxx-xxx"
  }
- O sistema também possui suporte para CEP inseridos diretamente, sem o caractere "-".
- A requisição deve ser feita para a path: v1/consulta-endereço, como uma requsição do tipo POST. Exemplo de request, corpo do request, e resposta, respectivamente:
- ![image](https://user-images.githubusercontent.com/38697815/229250647-2f84637c-688e-4cc8-9709-43c690bf93ba.png)
- ![image](https://user-images.githubusercontent.com/38697815/229250736-265041b6-db26-4e9a-abdb-62ec7815090f.png)
- ![image](https://user-images.githubusercontent.com/38697815/229250766-4b792428-0141-4b34-becb-9b9b7c1e9157.png)
