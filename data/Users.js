
let students = [
    {
        "id": "B8710298",
        "username": "wihobbs",
        "password": "hobbsman1",
        "userType": "student",
        "isVerified": true,
        "firstName": "Bill",
        "lastName": "Hobbs",
        "phoneNumber": 4204206969,
        "email": "williamhobbs@email.sc.edu",
        "resume": {
            "gpa": 3.9,
            "education": "BS Computer Science, BS Mathematics",
            "skills": [],
            "workExperiences": [
                {
                    "id": "1c9d3f89-e1b7-4a73-8486-b4ad34c9ae14",
                    "title": "NERSC Lab Intern",
                    "details": [
                        "Serve as a Lab Intern at NERSC",
                        "Work with rather large computers"
                    ],
                    "startDate": "05/01/2021",
                    "endDate": "08/20/2021",
                    "references": [
                        {
                            "firstName": "Jeff",
                            "lastName": "Koons",
                            "phoneNumber": 7843098073,
                            "email": "jkoons@gmail.com"
                        },
                        {
                            "firstName": "Kara",
                            "lastName": "Walker",
                            "phoneNumber": 6723333333,
                            "email": "kwalker@gmail.com"
                        }
                    ]
                }
            ],
            "courseExperiences": [
                {
                    "id": "ae5d1f8c-1350-4036-b5d7-7ac693cdf0b0",
                    "title": "Software Engineering",
                    "details": [
                        "Developed a software project in Java with a group of peers",
                        "Employed SCRUM/Agile development to create a functioning product"
                    ],
                    "startDate": "05/01/2021",
                    "endDate": "08/20/2021",
                    "grade": "A"
                },
                {
                    "id": "7c6ac4e2-4010-47b6-9074-f580fac6d47c",
                    "title": "Advanced Programming Techniques",
                    "details": [
                        "Coded advanced C++ programs"
                    ],
                    "startDate": "01/05/2021",
                    "endDate": "05/10/2021",
                    "grade": "A"
                }
            ],
            "clubExperiences": [
                {
                    "id": "741690ea-c168-4211-9b75-bcba8c6fd1ea",
                    "title": "Association for Computing Machinery UofSC Branch",
                    "description": [
                        "Served as club president"
                    ],
                    "startDate": "08/05/2021",
                    "endDate": "12/20/2021",
                    "role": "Club President"
                }
            ]
        }
    },
    {
        "id": "J78522814",
        "username": "joberman",
        "password": "G@meCok7",
        "userType": "student",
        "isVerified": true,
        "firstName": "Jack",
        "lastName": "Oberman",
        "phoneNumber": 3709012334,
        "email": "joberman@email.sc.edu",
        "resume": {
            "gpa": 1.0,
            "education": "BS Computer Science, BS Mathematics",
            "skills": [],
            "workExperiences": [],
            "courseExperiences": [],
            "clubExperiences": []
        }
    },
    {
        "id": "L8327109",
        "username": "natoliver",
        "password": "gamerBoi2",
        "userType": "student",
        "isVerified": true,
        "firstName": "Nathanael",
        "lastName": "Oliver",
        "phoneNumber": 1234567890,
        "email": "no2@email.sc.edu",
        "resume": {
            "gpa": 3.9,
            "education": "BS Computer Science, BS Mathematics",
            "skills": [],
            "workExperiences": [],
            "courseExperiences": [],
            "clubExperiences": [
                {
                    "id": "741690ea-c168-4211-9b75-bcba8c6fd1ea",
                    "title": "Association for Computing Machinery UofSC Branch",
                    "description": [
                        "Showed up regularly and ate pizza"
                    ],
                    "startDate": "08/05/2021",
                    "endDate": "12/20/2021",
                    "role": "Member"
                }
            ]
        }
    },
    {
        "id": "P1289123",
        "username": "brideguy9",
        "password": "tacoB3llH$ll",
        "userType": "student",
        "isVerified": false,
        "firstName": "Macbride",
        "lastName": "Noah",
        "phoneNumber": 09876541,
        "email": "macbride@email.sc.edu",
        "resume": {
            "gpa": 1.0,
            "education": "BS Computer Science",
            "skills": [],
            "workExperiences": [],
            "courseExperiences": [],
            "clubExperiences": []
        }
    }
];

let admins = [
    {
        "id": "37e75b8c-532d-40fe-b23c-a8d8a68b9c78",
        "username": "qwertyui",
        "password": "u93@2u4q98",
        "userType": "admin",
        "isVerified": true,
        "firstName": "Jasper",
        "lastName": "Johns"
    },
    {
        "id": "90d50390-d2b9-460c-aed4-1a606ca80ccf",
        "username": "aqsdfgh",
        "password": "5679hf45!2",
        "userType": "admin",
        "isVerified": false,
        "firstName": "Gustav",
        "lastName": "Klimt"
    }
];

let employers = [
    {
        "id": "6dd197f1-c14d-4a22-9bf3-6435f78df24e",
        "username": "uofscITdept",
        "password": "@d@f@gplmz",
        "userType": "employer",
        "isVerified": true,
        "title": "UofSC IT Dept.",
        "description": "University of South Carolina IT Department",
        "listings": [
            {
                "id": "fd0ef5ac-ec60-487e-b4ee-165c5fc45680",
                "payRate": 11.0,
                "location": "Columbia, South Carolina",
                "title": "IT Intern",
                "description": [
                    "Assist the IT help desk",
                    "Maintain school technology",
                    "Respond to technology requests from students and staff"
                ],
                "startDate": "05/01/2022",
                "endDate": "08/20/2022",
                "siteLink": "",
                "skills": [],
                "applicants": [
                    "L8327109"
                ]
            },
            {
                "id": "56c5e5a0-b788-42b1-959b-c73aa60135c5",
                "payRate": 38.5,
                "location": "Columbia, South Carolina",
                "title": "IT Desk Manager",
                "description": [
                    "Run the IT help desk",
                    "Maintain school technology",
                    "Respond to technology requests from students and staff"
                ],
                "startDate": "11/15/2021",
                "endDate": "",
                "siteLink": "",
                "skills": [],
                "applicants": []
            }
        ]
    },
    {
        "id": "01f78a8e-21a0-40cc-8b03-6155cb92986f",
        "username": "publix",
        "password": "p9o08h80n",
        "userType": "employer",
        "isVerified": true,
        "title": "Publix Supermarkets Inc",
        "description": "Publix Super Markets, Inc., commonly known as Publix, is an employee-owned American supermarket chain headquartered in Lakeland, Florida. Founded in 1930 by George W. Jenkins, Publix is a private corporation that is wholly owned by present and past employees and members of the Jenkins family.",
        "listings": [
            {
                "id": "f2c88aaa-dd37-46e4-abaf-919856ab5c4c",
                "payRate": 18.75,
                "location": "Greenville, South Carolina",
                "title": "Software Engineering Intern",
                "description": [],
                "startDate": "05/01/2022",
                "endDate": "08/20/2022",
                "siteLink": "https://www.publix.com/",
                "skills": [
                    "java", "linux", "css"
                ],
                "applicants": []
            }
        ]
    }
];