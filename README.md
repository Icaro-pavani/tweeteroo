# Tweetero

- Armazenamento de dados
    - Para persistir os dados (usuários e tweets), utilizou-se variáveis globais em memória;
    - O formato de um **usuário** é:
        
        ```jsx
        {
        	username: 'bobesponja', 
        	avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info" 
        }
        ```
        
    - O formato de um **tweet** é:
        
        ```jsx
        {
        	username: "bobesponja",
        	avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info", 
            text: "eu amo o hub"
        }
        ```

## Rotas
        
- **POST** `api/auth/sign-up`
    - Recebe (pelo body da request), um parâmetro **username** e um **avatar**, contendo o nome do username do usuário e a sua foto de avatar:
        
        ```jsx
        {
                username: "bobesponja",
        		avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
        }
        ```
        
    - E retornar a mensagem `“OK”`


- **POST** `/api/tweets`
    - Recebe (pelo body da request), o parâmetro `text`:
        
        ```jsx
        {
            text: "eu amo o hub"
        }
        ```
    - Recebe (pelo header da request),  parâmetro `User`:
        ```jsx
        {
            User: "bobesponja"
        }
        ```
        
    - Salva esse tweet num array de tweets do servidor
    - Por fim, retorna a mensagem `“OK”`


- **GET** `/api/tweets` com paginação
    - Retorna os 5 últimos tweets publicados
    - Esse endpoint recebe a página identificada via query string (`?page=1`).
    - Retorna corretamente os tweets da “página” (`page`) atual, esse endpoint também será chamado ao clicar no botão “**Carregar mais**” (isso já foi feito no front-end). A primeira página corresponde aos últimos 5 tweets, a segunda do 6 ao 10, a terceira do 11 ao 15, etc…
    - Formato da resposta é do tipo `Page` com o seguinte formato:
        
        ```jsx
        [
        	{
        		username: "bobesponja",
        		avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
        		tweet: "eu amo o hub"
        	}
        ]
        ```
        
- **GET** `/tweets/USERNAME`
    - Retorna todos os tweets publicados do usuario recebido por parâmetro de rota, da mesma forma que a rota anterior.