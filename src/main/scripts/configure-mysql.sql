# drop databases
DROP DATABASE IF EXISTS spring_recipe_app_dev;
DROP DATABASE IF EXISTS spring_recipe_app_prod;

# drop users
DROP USER IF EXISTS `spring_recipe_app_dev_user`@`%`;
DROP USER IF EXISTS `spring_recipe_app_prod_user`@`%`;

# create databases
CREATE DATABASE IF NOT EXISTS spring_recipe_app_dev CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
CREATE DATABASE IF NOT EXISTS spring_recipe_app_prod CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

# create users
CREATE USER IF NOT EXISTS `spring_recipe_app_dev_user`@`%` IDENTIFIED WITH mysql_native_password BY 'password';
CREATE USER IF NOT EXISTS `spring_recipe_app_prod_user`@`%` IDENTIFIED WITH mysql_native_password BY 'password';

# database grants to dev account
GRANT SELECT ON `spring_recipe_app_dev`.* TO `spring_recipe_app_dev_user`@`%`;
GRANT INSERT ON `spring_recipe_app_dev`.* TO `spring_recipe_app_dev_user`@`%`;
GRANT DELETE ON `spring_recipe_app_dev`.* TO `spring_recipe_app_dev_user`@`%`;
GRANT UPDATE ON `spring_recipe_app_dev`.* TO `spring_recipe_app_dev_user`@`%`;

# database grants to prod account
GRANT SELECT ON `spring_recipe_app_prod`.* TO `spring_recipe_app_prod_user`@`%`;
GRANT INSERT ON `spring_recipe_app_prod`.* TO `spring_recipe_app_prod_user`@`%`;
GRANT DELETE ON `spring_recipe_app_prod`.* TO `spring_recipe_app_prod_user`@`%`;
GRANT UPDATE ON `spring_recipe_app_prod`.* TO `spring_recipe_app_prod_user`@`%`;

FLUSH PRIVILEGES;