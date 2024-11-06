/*
LP-III BCT: Group C
4. Title: Write a program in solidity to create Student data. Use the following constructs:
• Structures
• Arrays
• Fallback
Deploy this as smart contract on Ethereum and Observe the transaction fee and Gas values

Name: Priti Balkrushna Aware
Class:BE - B
Batch:B2
Class:Computer Engineering
*/

// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentData {
    // Structure to hold student information
    struct Student {
        uint id;
        string name;
        uint age;
        string course;
    }

    // Array to store student records
    Student[] public students;

    // Fallback function to accept ether
    fallback() external payable {}

    // Function to add a new student
    function addStudent(string memory _name, uint _age, string memory _course) public {
        uint studentId = students.length; // Student ID based on current length of array
        students.push(Student(studentId, _name, _age, _course));
    }

    // Function to get student information by ID
    function getStudent(uint _id) public view returns (uint, string memory, uint, string memory) {
        require(_id < students.length, "Student ID does not exist.");
        Student memory student = students[_id];
        return (student.id, student.name, student.age, student.course);
    }

    // Function to get total number of students
    function getTotalStudents() public view returns (uint) {
        return students.length;
    }
}
