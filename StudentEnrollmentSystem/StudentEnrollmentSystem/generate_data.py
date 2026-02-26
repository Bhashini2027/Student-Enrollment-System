import random

first_names = ["Tharindu", "Kasun", "Nimal", "Saman", "Kamal", "Ruwan", "Lahiru", "Nuwan", "Chathura", "Ishara",
               "Ashan", "Kavindu", "Sandun", "Ramesh", "Dinuka", "Sameera", "Nipun", "Harsha", "Janaka", "Sumudu",
               "Nadeeka", "Kumari", "Thilini", "Dinusha", "Nishanthi", "Kavindi", "Nethmi", "Oshadi", "Sewwandi", "Heshani"]

last_names = ["Perera", "Silva", "Bandara", "Fernando", "de Silva", "Jayakody", "Gunawardena", "Weerasinghe",
              "Dissanayake", "Jayasinghe", "Gamage", "Senanayake", "Herath", "Rathnayake", "Karunaratne",
              "Liyanage", "Fonseka", "Ekanayake", "Munasinghe", "Amarasinghe"]

courses = ["CS101", "SE202", "IT303", "IS404", "DS505", "ENG101", "MAT201"]
districts = ["Colombo", "Gampaha", "Kalutara", "Kandy", "Matale", "Nuwara Eliya", "Galle", "Matara", "Hambantota",
             "Jaffna", "Kilinochchi", "Mannar", "Vavuniya", "Mullaitivu", "Batticaloa", "Ampara", "Trincomalee",
             "Kurunegala", "Puttalam", "Anuradhapura", "Polonnaruwa", "Badulla", "Moneragala", "Ratnapura", "Kegalle"]

def generate_record(i):
    student_id = f"STU{1000 + i}"
    full_name = f"{random.choice(first_names)} {random.choice(last_names)}"
    nic_num = f"{random.randint(90, 99)}{random.randint(0, 3)}{random.randint(100, 365)}{random.randint(1000, 9999)}v"
    course = random.choice(courses)
    gpa = round(random.uniform(2.0, 4.0), 2)
    district = random.choice(districts)
    is_enrolled = random.choice(["TRUE", "FALSE"])
    dob = f"{random.randint(1, 12)}/{random.randint(1, 28)}/199{random.randint(0, 9)}"
    
    return f"{student_id}\t{full_name}\t{nic_num}\t{course}\t{gpa}\t{district}\t{is_enrolled}\t{dob}"

records = []
records.append("Student ID\tFull Name\tNIC Number\tCourse Code\tGPA\tDistrict\tIs Enrolled\tDate of Birth")
for i in range(1, 155):
    records.append(generate_record(i))

with open('c:/Users/user/OneDrive/Desktop/StudentEnrollmentSystem/enroll records.txt', 'w') as f:
    for record in records:
        f.write(record + "\n")
