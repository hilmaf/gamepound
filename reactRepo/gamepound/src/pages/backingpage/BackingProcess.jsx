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

    const [ProjectBriefVo, setProjectBriefVo] = useState({});
    const [BackVo, setBackVo] = useState({});

    // 프로젝트 정보, 후원 정보 fetch
    const loadBackingFormInfo = () => {
        fetch("http://127.0.0.1:8889/gamepound/back/process")
        .then(resp => {return resp.json()})
        .then(data => {
            console.log(data.ProjectBriefInfo);
            setProjectBriefVo(data.ProjectBriefVo);
            setBackVo(data.BackVo);
        })
        ;
    }

    // 렌더링 1번만
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