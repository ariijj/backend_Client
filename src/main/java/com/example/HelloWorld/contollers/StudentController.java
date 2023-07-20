package com.example.HelloWorld.contollers;

import com.example.HelloWorld.Entity.AuthenticationRequest;
import com.example.HelloWorld.Entity.AuthenticationResponse;
import com.example.HelloWorld.Entity.Student;
import com.example.HelloWorld.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("api/v1/student")
public class StudentController {
private AuthenticationManager authenticationManager;

    @Autowired
    private StudentService studentServices;
    @PostMapping(name="/upload", consumes = "multipart/form-data")
    public ResponseEntity<?> upload(@RequestParam("CV") MultipartFile CV, @RequestParam("letttre_motivation") MultipartFile lettre_motivation,@RequestParam("image") MultipartFile Image,@RequestParam("Name") String name,@RequestParam("studentaddress") String studentaddress,@RequestParam("mobile") String mobile,@RequestParam("studentbirth") String studentbirth,@RequestParam("studentemail") String studentemail,@RequestParam("passwod") String passwod,@RequestParam("compassword") String compassword) throws IOException {
        return new ResponseEntity<>(studentServices.addCandidat(CV,lettre_motivation,Image, name, studentaddress, mobile,studentbirth, studentemail,passwod,compassword), HttpStatus.OK);
    }
    @PostMapping("/auth")
    private  ResponseEntity<?> authenticateClient(@RequestBody AuthenticationRequest authenticationRequest){
       try {
           authenticationManager.authenticate(new UsernamePasswordauthenticationToken(Email, password));
       }catch(Exception e){
           return ResponseEntity.ok(new AuthenticationResponse("Bad request" ));
       }
        String email=authenticationRequest.getUserEmail();
        String pwd=authenticationRequest.getPassword();
     return ResponseEntity.ok(new AuthenticationResponse("Succesful Subscription for client" ));

    }
    @GetMapping("/getall")
    private Iterable<Student>getStudents(){

        return studentServices.listAll();
    }
    @PutMapping(value = "/edit/{id}")
    private Student update(@RequestBody Student student,@PathVariable(name="id")String _id){

        student.set_id(_id);
        studentServices.saveorUpdate(student);
        return student;
    }
    @DeleteMapping("/delete/{id}")
    private void deleteStudent(@PathVariable("id")String  _id){
        studentServices.deleteStudent(_id);

    }
    @RequestMapping("/search/{id}")
    private Student getStudents(@PathVariable(name="id")String studentid){
        return studentServices.getStudentByID(studentid);}}
