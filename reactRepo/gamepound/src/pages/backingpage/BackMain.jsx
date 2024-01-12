import React from 'react';
import BackingProcess from './backing/BackingProcess';
import { Route, Routes } from 'react-router-dom';
import BackCompleted from './BackCompleted';
import BackCanceled from './BackCanceled';
import BackDetail from './BackDetail';


const BackMain = () => {
    return (
        <Routes>
            <Route path='process' element={<BackingProcess />}/>
            <Route path='completed' element={<BackCompleted />}/>
            <Route path='canceled' element={<BackCanceled />}/>
            <Route path='detail/:no' element={<BackDetail />}/>
        </Routes>

    );
};

export default BackMain;