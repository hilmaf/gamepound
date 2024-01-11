import React from 'react';
import { Route, Routes } from 'react-router-dom';
import ProjectNewCreate from './ProjectNewCreate';
import ProjectStartCreate from './ProjectStartCreate';
import ProjectCreateMain from './ProjectCreateMain';

const CreateMain = () => {
    return (
        <Routes>
            <Route path='start' element={<ProjectStartCreate />}></Route>
            <Route path='new' element={<ProjectNewCreate />}></Route>
            <Route path='main/*' element={<ProjectCreateMain />}></Route>
        </Routes>
    );
};

export default CreateMain;