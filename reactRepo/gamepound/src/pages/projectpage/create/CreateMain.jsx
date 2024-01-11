import React from 'react';
import { Route, Routes } from 'react-router-dom';
import ProjectNewCreate from './ProjectNewCreate';
import ProjectStartCreate from './ProjectStartCreate';

const CreateMain = () => {
    return (
        <Routes>
            <Route path='start' element={<ProjectStartCreate />}></Route>
            <Route path='new' element={<ProjectNewCreate />}></Route>
        </Routes>
    );
};

export default CreateMain;