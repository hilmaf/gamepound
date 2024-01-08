import React from 'react';
import { Route, Routes } from 'react-router-dom';
import ListMain from "./list/ListMain";
import DetailMain from './detail/DetailMain';
const ProjectMain = () => {
    return (<>
        <Routes>
            <Route path='/list/*' element={<ListMain/>}></Route>
            <Route path='/detail/*' element={<DetailMain/>}></Route>
        </Routes>        
    </>);
};

export default ProjectMain;