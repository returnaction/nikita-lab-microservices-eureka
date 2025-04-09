// Получаем элементы со страницы по их id, чтобы с ними работать в скрипте:
// form — вся форма
// nameInput — поле для ввода имени
// emailInput — поле для email
// userList — <ul>, куда будем вставлять пользователей
const form = document.getElementById('user-form')
const nameInput = document.getElementById('name')
const emailInput = document.getElementById('email')
const userList = document.getElementById('user-list')

// 🔹 Асинхронная функция, которая запрашивает всех пользователей с backend (по API Gateway 8080)
// fetch делает GET-запрос на /api/users
// response.json() превращает JSON в массив объектов пользователей
async function fetchUsers() {
    const response = await fetch('http://localhost:8080/api/users')
    const users = await response.json()

    userList.innerHTML = ''
    users.forEach(user => {
        const li = document.createElement('li')
        li.textContent = `${user.name} (${user.email})`
        userList.appendChild(li)
    })
}

form.addEventListener('submit', async (e) => {
    e.preventDefault()

    const newUser = {
        name: nameInput.value,
        email: emailInput.value
    }

    await fetch('http://localhost:8080/api/users', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newUser)
    })

    nameInput.value = ''
    emailInput.value = ''
    fetchUsers()
})

fetchUsers()
