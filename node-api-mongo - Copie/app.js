const express = require('express');
const app = express();

// Using Node.js `require()`
const mongoose = require('mongoose');
const config = require('config');
const dbConfig = config.get('Customer.dbConfig.dbName');

const useRouter = require('./Routes/user');

//connection bddd

mongoose.connect( dbConfig,{

            }).then(() => {
                console.log('MongoDB connected!!');
            }).catch(err => {
                console.log('Failed to connect to MongoDB', err);
            });


//morgan
//app.use(morgan, ('dev'));
app.use(express.json());


app.use((req, res, next) => {
    res.header('Access-Control-Allow-Origin', '*');
    res.header(
        'Access-Control-Allow-Headers',
        'Origin,X-Requested-With,Content-Type,Accept,Authorization'
    );

    if (req.method === 'OPTIONS') {
        res.header('Accept-Control-Methods', 'PUT,POST,PATCH,DELETE,GET');
        return res.status(200).json({

        })
    }
    next();
});



app.use('/user', useRouter);

app.use((req, res, next) => {
    const error = new Error('Not Found');
    next(error);
});

app.use((error, req, res, next) => {
    res.status(error.status || 500);
    res.json({
        error: {
            message: error.message
        }
    })
});

app.listen(5500, () => console.log('Server started: 5500'));