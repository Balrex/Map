# Задача: 
  реализовать ассоциативный массив (контейнер map) на основе двоичного дерева поиска. Каждый узел двоичного дерева должен содержать пару ключ-значение. Пользователь должен иметь возможность: получить значение по ключу, изменить значение по ключу, добавить в контейнер новую пару.
  
# Указания по выполнению:
- лабораторная работа состоит из двух файлов:
map – описание класса map, прототипы методов, реализация методов;
test-map – тестирование и проверка возможностей класса;
- создать вспомогательную шаблонную структуру node, содержащую поле
для хранения значения произвольного типа и 3 поля для хранения указателей
на родителя и левого/правого потомков;
- создать шаблонный класс comparator. Реализация данного класса может быть опущена при отсутствии языковой поддержки;
- класс map содержит три шаблонных параметра: тип ключа; тип значения; тип критерия сравнения (по умолчанию comparator);
- каждый узел дерева в поле данных содержит пару ключ-значение;
- класс map содержит одно поле – указатель на узел, являющийся корнем
дерева.
- класс map должен содержать следующие методы:
-- конструктор;
-- конструктор копирования;
-- копирующий оператор присваивания;
-- проверка на пустоту;
-- удаление всех элементов;
-- добавление пары ключ-значение;
-- метод – получает ключ, возвращает ссылку на значение.
