// document.addEventListener('DOMContentLoaded', function() {
//     const loginBtn = document.getElementById('loginBtn');
//     const signupBtn = document.getElementById('signupBtn');
//     const loginPage = document.getElementById('loginPage');
//     const signupPage = document.getElementById('signupPage');

//     loginBtn.addEventListener('click', function() {
//         loginPage.classList.remove('hidden');
//         signupPage.classList.add('hidden');
//     });

//     signupBtn.addEventListener('click', function() {
//         signupPage.classList.remove('hidden');
//         loginPage.classList.add('hidden');
//     });

//     const loginForm = document.getElementById('loginForm');

//     loginForm.addEventListener('submit', function(event) {
//         event.preventDefault();

//         const username = document.getElementById('username').value;
//         const password = document.getElementById('password').value;

//         console.log('Username:', username);
//         console.log('Password:', password);

//         // Send login credentials to the server for authentication
//         // Assume successful login for demonstration purposes
//         // Replace this with actual authentication logic

//         // Redirect to the home page after successful login
//         window.location.href = '/home.html'; // Replace 'home.html' with the URL of your home page
//     });

//     const registerForm = document.getElementById('signupForm');

//     registerForm.addEventListener('submit', function(event) {
//         event.preventDefault();

//         const fullName = document.getElementById('fullName').value;
//         const email = document.getElementById('email').value;
//         const newUsername = document.getElementById('newUsername').value;
//         const newPassword = document.getElementById('newPassword').value;

//         console.log('Full Name:', fullName);
//         console.log('Email:', email);
//         console.log('Username:', newUsername);
//         console.log('Password:', newPassword);

//         // Send verification email
//         sendVerificationEmail(fullName, email);

//         // Redirect to the image page after a short delay
//         setTimeout(function() {
//             window.location.href = 'https://cdscoonline.gov.in/CdscoManuals/Registration%20Guidelines/!SSL!/Multiscreen_HTML5/android_phone/registration-12.png';
//         }, 1000); // Delay in milliseconds (adjust as needed)
//     });
 
//     function sendVerificationEmail(fullName, email) {
//         // Send a request to your backend to send the verification email
//         fetch('/send-verification-email', {
//             method: 'POST',
//             headers: {
//                 'Content-Type': 'application/json'
//             },
//             body: JSON.stringify({
//                 fullName: fullName,
//                 email: email
//             })
//         })
//         .then(response => {
//             if (response.ok) {
//                 console.log('Verification email sent successfully');
//             } else {
//                 console.error('Failed to send verification email');
//             }
//         })
//         .catch(error => {
//             console.error('Error sending verification email:', error);
//         });
//     }
// });
