import random
import string
print("Want to generate a password? Go ahead!")
length = int(input("Enter password length: "))
chars = string.ascii_letters + string.digits + string.punctuation
password = ''.join(random.choice(chars) for _ in range(length))
print("Generated password:", password)
