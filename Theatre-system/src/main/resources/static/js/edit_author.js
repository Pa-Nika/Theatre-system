$(function() {
    $('#birthday').datepicker({
        format: 'dd.mm.yyyy', // формат даты
        autoclose: true, // закрытие календаря после выбора даты
        orientation: 'bottom' // расположение календаря относительно поля ввода
    });
});