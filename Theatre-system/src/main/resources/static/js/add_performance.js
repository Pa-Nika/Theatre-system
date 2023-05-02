$(function() {
    $('#premiere').datepicker({
        format: 'dd.mm.yyyy', // формат даты
        autoclose: true, // закрытие календаря после выбора даты
        orientation: 'bottom' // расположение календаря относительно поля ввода
    });
});

function validateLimit(value) {
    const limitInput = document.getElementById('limit');
    const errorElement = document.getElementById('limit-error');

    if (!Number.isInteger(+value) || +value < 0 || +value > 22) {
        limitInput.classList.add('is-invalid');
        errorElement.textContent = 'Введите возраст от 0 до 21';
    } else {
        limitInput.classList.remove('is-invalid');
        errorElement.textContent = '';
    }
}


function validateTime(value) {
    const timeInput = document.getElementById('time');
    const errorElement = document.getElementById('time-error');

    if (!Number.isInteger(+value) || +value < 0 || +value > 241) {
        timeInput.classList.add('is-invalid');
        errorElement.textContent = 'Введите число от 0 до 240 мин. Больше - ну неееет, не надо, это больно';
    } else {
        timeInput.classList.remove('is-invalid');
        errorElement.textContent = '';
    }
}

const form = document.getElementById('edit-form');
form.addEventListener('submit', function(event) {
    // Получаем значения полей и проверяем их
    const limitValue = document.getElementById('limit').value;
    const timeValue = document.getElementById('time').value;
    validateLimit(limitValue);
    validateTime(timeValue);

    // Если данные введены неправильно, отменяем отправку формы
    if (document.querySelectorAll('.is-invalid').length > 0) {
        event.preventDefault(); // Отмена отправки формы
        return false;
    }

    // Если данные введены правильно, отправляем форму
    return true;
});
