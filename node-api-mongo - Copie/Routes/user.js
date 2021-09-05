const express = require('express');
const router = express.Router();
const User = require('../Model/user');
const mongoose = require('mongoose');

router.get('/', (req, res, next) => {
    res.status(200).json({
        message: "hello this user request"
    });
});


router.post('/', (req, res, next) => {
    
//Il y a deja un userverification du mail
User.find({mail:req.body.mail}).exec().
then(result=>{
    if(result.length>=1){
        res.status(422).json({
            message:"user already exist"
        });
    }else

    //debut ajout
    {
        const user_1 = new User({
            _id: mongoose.Types.ObjectId(),
            mail: req.body.mail,
            name: req.body.name,
            age: req.body.age
    
        });
    
        user_1.save().then(result => {
            console.log(result);
    
            res.status(200).json({
                message: result
            });
    
        }).catch(err => {
            console.log(err);
            res.status(500).json({
                message: err
    
            });
        });   
    }


    //fin ajout
}).catch(err=>{


    res.status(500).json({
        message: err
    
  });

//ajout user
    const user_1 = new User({
        _id: mongoose.Types.ObjectId(),
        mail: req.body.mail,
        name: req.body.name,
        age: req.body.age

    });

    user_1.save().then(result => {
        console.log(result);

        res.status(200).json({
            message: result
        });

    }).catch(err => {
        console.log(err);
        res.status(500).json({
            message: err

        });
    });
});


router.post('/:userid', (req, res, next) => {

    const userid = req.params.userid;

    res.status(200).json({
        message: "hello this post request",
        "user_name": req.body.name,
        "user_age": req.body.age,
        "useride": userid

    });
});

router.put('/', (req, res, next) => {
    res.status(200).json({
        message: "hello this put request"
    });
});


router.patch('/', (req, res, next) => {
    res.status(200).json({
        message: "hello this patch request"
    });
});


router.delete('/', (req, res, next) => {
    res.status(200).json({
        message: "hello this delete request"
    });
});

});

module.exports = router;
