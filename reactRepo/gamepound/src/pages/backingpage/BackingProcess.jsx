import React, { useEffect, useState } from 'react';
import {styled} from 'styled-components';
import ProjectBriefInfo from '../../component/project/ProjectBriefInfo';
import BackingForm from '../backingpage/BackingForm';

const StyledBackingFormDiv = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: start;
    align-items: center;
`;

const BackingProcess = () => {

    const [ProjectBriefVo, setProjectBriefVo] = useState();
    const [BackVo, setBackVo] = useState();

    const loadBackingFormInfo = () => {
        fetch("http://127.0.0.1:8889/gamepound/back/process")
        .then(resp => {return resp.json()})
        .then(data => {
            setProjectBriefVo(data.ProjectBriefVo);
            setBackVo(data.BackVo);
        })
        ;
    }

    useEffect(()=>{
        loadBackingFormInfo();
    }, [])

    return (
        <StyledBackingFormDiv>
            <ProjectBriefInfo ProjectBriefInfo={ProjectBriefVo}/>
            <BackingForm BackingInfo={BackVo}/>
        </StyledBackingFormDiv>
    );
};

export default BackingProcess;