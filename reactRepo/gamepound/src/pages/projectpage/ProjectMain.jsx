import React from 'react';
import { Route, Routes } from 'react-router-dom';
import ListMain from "./list/ListMain";
import DetailMain from './detail/DetailMain';
import PrelaunchDetailMain from './detail/PrelaunchDetailMain';
const ProjectMain = () => {

    return (<>
        <Routes>
            <Route path='/list/*' element={<ListMain/>}></Route>
            <Route path='/detail/:temp/:no' element={<DetailMain/>} />
            <Route path='/detail/prelaunch/*'>
                <Route path=':temp/:no' element={<PrelaunchDetailMain/>}></Route>
            </Route>
        </Routes>        
    </>);
};

export default ProjectMain;