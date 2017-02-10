@test


Feature: Check authorisation on Ozon.ru

      Background:
        Given I open ozon
        And I click button with name Мой Ozon

       Scenario: check authorisation with Личный кабинет
       Given I click button with name Личный кабинет
        When I enter in field Мой логин: "Azick200@gmail.com"
         And I enter in field Мой пароль: "123456"
         And I click button with name Продолжить
        Then I should be see account name "Test"
         And I should be see personal study text "Личный кабинет"
         And I should be see welcome text "Мы рады вам, Test"

        Scenario: check authorisation with Вход
        Given I click  button with name Вход
         When I enter in field логин: "Azick200@gmail.com"
          And I enter in field пароль: "123456"
          And I click button with name Войти
         Then I should be see account name "Test"




