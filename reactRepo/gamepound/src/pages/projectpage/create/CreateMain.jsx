import React from 'react';
import { Route, Routes } from 'react-router-dom';
import ProjectNewCreate from './ProjectNewCreate';

const CreateMain = () => {
    return (
        <Routes>
            <Route path='new' element={<ProjectNewCreate />}></Route>
        </Routes>
    );
};

export default CreateMain;