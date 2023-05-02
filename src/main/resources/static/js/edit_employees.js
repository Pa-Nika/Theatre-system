$(function() {
    $('#birthday').datepicker({
        format: 'dd.mm.yyyy', // формат даты
        autoclose: true, // закрытие календаря после выбора даты
        orientation: 'bottom' // расположение календаря относительно поля ввода
    });
});

$(function() {
    $('#work').datepicker({
        format: 'dd.mm.yyyy', // формат даты
        autoclose: true, // закрытие календаря после выбора даты
        orientation: 'bottom' // расположение календаря относительно поля ввода
    });
});

function validateChildren(value) {
    const childrenInput = document.getElementById('children');
    const errorElement = document.getElementById('children-error');

    if (!Number.isInteger(+value) || +value < 0 || +value > 10) {
        childrenInput.classList.add('is-invalid');
        errorElement.textContent = 'Введите число от 0 до 10';
    } else {
        childrenInput.classList.remove('is-invalid');
        errorElement.textContent = '';
    }
}


function validateSalary(value) {
    const salaryInput = document.getElementById('salary');
    const errorElement = document.getElementById('salary-error');

    if (!Number.isInteger(+value) || +value < 0 || +value > 1000000) {
        salaryInput.classList.add('is-invalid');
        errorElement.textContent = 'Введите число от 0 до 1000000';
    } else {
        salaryInput.classList.remove('is-invalid');
        errorElement.textContent = '';
    }
}

const form = document.getElementById('edit-form');
form.addEventListener('submit', function(event) {
    // Получаем значения полей и проверяем их
    const childrenValue = document.getElementById('children').value;
    const salaryValue = document.getElementById('salary').value;
    validateChildren(childrenValue);
    validateSalary(salaryValue);

    // Если данные введены неправильно, отменяем отправку формы
    if (document.querySelectorAll('.is-invalid').length > 0) {
        event.preventDefault(); // Отмена отправки формы
        return false;
    }

    // Если данные введены правильно, отправляем форму
    return true;
});
