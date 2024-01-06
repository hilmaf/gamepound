import React from 'react';
import BackingProcess from './BackingProcess';
import { Route, Routes } from 'react-router-dom';


const BackMain = () => {
    return (
        <Routes>
            <Route path='process' element={<BackingProcess />}/>
            <Route path='completed' element={<BackingProcess />}/>
            <Route path='canceled' element={<BackingProcess />}/>
            <Route path='detail' element={<BackingProcess />}/>
        </Routes>

    );
};

export default BackMain;