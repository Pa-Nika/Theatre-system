function validateHeight(value) {
    const heightInput = document.getElementById('height');
    const errorElement = document.getElementById('height-error');

    if (!Number.isInteger(+value) || +value < 0 || +value > 250) {
        heightInput.classList.add('is-invalid');
        errorElement.textContent = 'Введите число от 0 до 250 см';
    } else {
        heightInput.classList.remove('is-invalid');
        errorElement.textContent = '';
    }
}


function validateAge(value) {
    const ageInput = document.getElementById('age');
    const errorElement = document.getElementById('age-error');

    if (!Number.isInteger(+value) || +value < 0 || +value > 150) {
        ageInput.classList.add('is-invalid');
        errorElement.textContent = 'Введите число от 0 до 150';
    } else {
        ageInput.classList.remove('is-invalid');
        errorElement.textContent = '';
    }
}

const form = document.getElementById('edit-form');
form.addEventListener('submit', function(event) {
    // Получаем значения полей и проверяем их
    const heightValue = document.getElementById('height').value;
    const ageValue = document.getElementById('age').value;
    validateHeight(heightValue);
    validateAge(ageValue);

    // Если данные введены неправильно, отменяем отправку формы
    if (document.querySelectorAll('.is-invalid').length > 0) {
        event.preventDefault(); // Отмена отправки формы
        return false;
    }

    // Если данные введены правильно, отправляем форму
    return true;
});
