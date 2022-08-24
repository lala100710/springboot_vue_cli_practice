# springboot_vue_cli_practice

 利用  mariadb + Spring Data JPA 以及 vue cli 完成 user management 練習

## vue cli 設定

### 建立node_modules 資料夾 

在路徑為 springboot_vue_cli_practice/user_management/fronted 開啟終端機

利用  輸入 npm install 指令

### 下載boostrap modules

npm install --save bootstrap
npm install @popperjs/core --save

### 啟動vue cli

利用 終端機 輸入 npm run serve 指令

### Local:   http://localhost:8080/

### Network: http://192.168.20.47:8080/

### 以下為成功執行畫面

 ![image](https://user-images.githubusercontent.com/80452917/186076127-82d79d5e-c6b6-4992-a3ab-dd93cfee0ad7.png)

### 資料庫連結

#### spring.datasource.url=jdbc:mariadb://localhost:3306/user

#### 查詢所有 user

  search 根據 name 查詢 user 資料，若 search 沒有輸入內容則會顯示所有資料
![image](https://user-images.githubusercontent.com/80452917/186075546-8a4ebca7-59d7-4ff4-9219-05cc06fbf47c.png)

#### 新增 user

![image](https://user-images.githubusercontent.com/80452917/186075684-2a3096e7-e08d-4132-84dd-dfc4341f4d0e.png)

#### 修改 user

  預設內容為點擊的 id 所取得的資料
 ![image](https://user-images.githubusercontent.com/80452917/186078824-8363ffbe-b7bd-43d9-b6ef-e5cbff69ca31.png)

![image](https://user-images.githubusercontent.com/80452917/186077973-39ad3a2f-5e00-4c77-9b80-93ccdc3f3b81.png)

#### 刪除 user

![image](https://user-images.githubusercontent.com/80452917/186078924-0d348d33-c2e1-4e0a-95c7-0aac341a94b3.png)

##### 再次確認是否刪除

![image](https://user-images.githubusercontent.com/80452917/186087729-2a0dc429-f438-43be-acc9-15638a5ddc86.png)
